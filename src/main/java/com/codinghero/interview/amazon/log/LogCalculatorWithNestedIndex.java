package com.codinghero.interview.amazon.log;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LogCalculatorWithNestedIndex {
    private Map<Long, Set<Long>> userCountToPageIds;

    private Map<Long, Set<Long>> pageIdToUserIds;

    public Set<Long> getPageByUserCount(Long userCount) {
        return userCountToPageIds.get(userCount);
    }

    public void insertLog(Long userId, Long pageId) {
        this.handlePageIdToUserIds(userId, pageId);
    }

    private void handlePageIdToUserIds(Long userId, Long pageId) {
        Set<Long> userIds = pageIdToUserIds.get(pageId);
        if (userIds == null) {
            userIds = new HashSet<Long>();
            pageIdToUserIds.put(pageId, userIds);
        }
        
        if (!userIds.contains(userId)) {
            userCountToPageIds.get(userIds.size()).remove(pageId);
            userIds.add(userId);
            userCountToPageIds.get(userIds.size()).add(pageId);
        }
    }
}
