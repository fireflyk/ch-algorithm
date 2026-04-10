package com.codinghero.interview.amazon.log;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LogCalculator {

    // Q1
    private Map<Long, Set<Long>> uvToPageIds;

    // Q1
    private Map<Long, Set<Long>> pageIdToUserIds;

    // Q2
    private Map<Long, Set<Long>> pvToPageIds;

    // Q2
    private Map<Long, Long> pageIdToPV;

    // Q3
    private Map<Long, Set<Long>> userIdToPageIds;

    public void insertLog(Long userId, Long pageId) {
        this.handlePageIdToUserIds(userId, pageId);
        this.handlePageIdToPV(userId, pageId);
        this.handleUserIdToPageIds(userId, pageId);
    }

    public Set<Long> getPageIdByUV(Long uv) {
        return uvToPageIds.get(uv);
    }

    public Set<Long> getPageIdByUVAndPV(Long uv, Long pv) {
        Set<Long> pageIds1 = uvToPageIds.get(uv);
        Set<Long> pageIds2 = pvToPageIds.get(pv);
        Set<Long> result = new HashSet<Long>(pageIds1);
        result.addAll(pageIds2);
        return result;
    }

    public Set<Long> getPageIdByUserIdAndPV(Long userId, Long pv) {
        Set<Long> pageIds1 = userIdToPageIds.get(userId);
        Set<Long> pageIds2 = pvToPageIds.get(pv);
        Set<Long> result = new HashSet<Long>(pageIds1);
        result.addAll(pageIds2);
        return result;
    }

    private void handlePageIdToUserIds(Long userId, Long pageId) {
        Set<Long> userIds = pageIdToUserIds.get(pageId);
        if (userIds == null) {
            userIds = new HashSet<Long>();
            pageIdToUserIds.put(pageId, userIds);
        }

        if (!userIds.contains(userId)) {
            userIds.add(userId);
            if (userIds.size() > 0) {
                uvToPageIds.get(userIds.size() - 1).remove(pageId);
            }
            uvToPageIds.get(userIds.size()).add(pageId);
        }
    }

    private void handlePageIdToPV(Long userId, Long pageId) {
        Long pv = pageIdToPV.get(pageId);
        if (pv == null) {
            pv = 1L;
            pageIdToPV.put(pageId, pv);
        } else {
            pv += 1;
        }

        if (pv > 1) {
            pvToPageIds.get(pv - 1).remove(pageId);
        }
        pvToPageIds.get(pv).add(pageId);
    }

    private void handleUserIdToPageIds(Long userId, Long pageId) {
        Set<Long> pageIds = userIdToPageIds.get(userId);
        if (pageIds == null) {
            pageIds = new HashSet<Long>();
            userIdToPageIds.put(userId, pageIds);
        }
    }
}
