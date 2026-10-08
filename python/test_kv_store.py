import unittest

from kv_store import BlockDevice, KVStore


class FakeBlockDevice(BlockDevice):
    def __init__(self, number_of_blocks: int):
        self._blocks = ["" for _ in range(number_of_blocks)]

    def number_of_blocks(self) -> int:
        return len(self._blocks)

    def read(self, block_id: int) -> str:
        return self._blocks[block_id]

    def write(self, block_id: int, data: str) -> None:
        self._blocks[block_id] = data


class KVStoreTest(unittest.TestCase):
    def test_init_starts_with_all_blocks_free(self):
        block_device = FakeBlockDevice(4)
        store = KVStore(block_device)

        self.assertEqual(store.numbers_of_free_blocks(), 4)

    def test_get_missing_key_returns_none(self):
        block_device = FakeBlockDevice(4)
        store = KVStore(block_device)

        self.assertIsNone(store.get("missing"))


if __name__ == "__main__":
    unittest.main()
