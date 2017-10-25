package com.nakanara.rdb;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ResultDao  {
    @Getter @Setter
    List result;

    @Getter
    long totalCount = 0; // 총 건수

    @Getter @Setter
    int pageSize = 20;   //페이지 사이즈

    @Getter @Setter
    int totalPage = 0;  // 총 페이지

    public static final int DEF_PAGE_SIZE = 20;

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;

        if(totalCount == 0) totalPage = 1;
        if(pageSize == 0) pageSize = DEF_PAGE_SIZE;

        totalPage = (int)(totalCount/pageSize) +1;

    }

    @Override
    public String toString() {
        return "ResultDao{" +
                "result=" + result.size() +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
