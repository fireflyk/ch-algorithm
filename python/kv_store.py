class BlockDevice:
    BLOCK_SIZE = 8
    
    def number_of_blocks(self) -> int:
        pass
    
    def read(self, block_id: int) -> str:
        pass
    
    def write(self, block_id: int, data: str) -> None:
        pass

class KVStore:

    _block_device: BlockDevice
    # key is string, value is list of block ids
    _key_to_block_ids: dict
    # this is a list of free block ranges
    _free_blocks: list
    
    def __init__(self, block_device: BlockDevice):
        self._block_device = block_device
        self._key_to_block_ids = {}
        # how to put a range, tuple or interval to the free_blocks list?
        self._free_blocks = [range(0, block_device.number_of_blocks())]

    def numbers_of_free_blocks(self) -> int:
        return sum(map(lambda x: x.stop - x.start, self._free_blocks))
    
    def numbers_of_required_blocks(value: str) -> int:
        return self.numbers_of_required_blocks(0, len(value))
    
    def numbers_of_required_blocks(value: str, inclusiveStartIndex: int) -> int:
        return self.numbers_of_required_blocks(inclusiveStartIndex, len(value))

    def numbers_of_required_blocks(inclusiveStartIndex: int, exclusiveEndIndex: int) -> int:
        return (exclusiveEndIndex - inclusiveStartIndex + BlockDevice.BLOCK_SIZE - 1) // BlockDevice.BLOCK_SIZE

    def set(self, key: str, value: str):
        # check if we have enough free blocks
        if self.numbers_of_free_blocks() < self.numbers_of_required_blocks(value):
            raise Exception("Not enough free blocks")
        valueIndex = 0
        # for loop free blocks and allocate them
        for free_block in self._free_blocks:
            if free_block.stop - free_block.start >= self.numbers_of_required_blocks(value, valueIndex):
                # allocate blocks
                for i in range(self.numbers_of_required_blocks(value, valueIndex)):
                    self._block_device.write(free_block.start + i, value[valueIndex:min(valueIndex + BlockDevice.BLOCK_SIZE, len(value))])
                    valueIndex += BlockDevice.BLOCK_SIZE
                # update free_blocks
                self._free_blocks.remove(free_block)
                self._free_blocks.append(range(free_block.start + self.numbers_of_required_blocks(value, valueIndex), free_block.stop))
                break
            else:
                # allocate blocks
                for i in range(free_block.stop - free_block.start):
                    self._block_device.write(free_block.start + i, value[valueIndex:valueIndex + BlockDevice.BLOCK_SIZE])
                    valueIndex += BlockDevice.BLOCK_SIZE
                # update free_blocks
                self._free_blocks.remove(free_block)

    def get(self, key: str) -> str:
        block_ids = self._key_to_block_ids.get(key)
        if block_ids is None:
            return None
        else:
            # join the read result to a string
            return ''.join(map(lambda block_id: self._block_device.read(block_id), block_ids))

    def delete(self, key: str):
        pass

    def clear(self):
        pass
