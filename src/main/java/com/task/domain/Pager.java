package com.task.domain;

import java.util.List;

/**
 * @author wangchenyang
 * @desc 分页基类
 * @date 2018/4/17
 */
public class Pager<T> {

    //当前页
    private long currentPage = 1;

    //每页条数
    private long pageSize = 10;

    //总条数
    private long totalRow;

    //总页数
    private long totalPage;

    //是否有下一页
    private Integer isMore;

    //分页结果
    private List<T> records;

    public Pager(long currentPage, long pageSize, long totalRow, List<T> records) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRow = totalRow;
        this.totalPage = (this.totalRow + this.pageSize - 1) / this.pageSize;
        this.records = records;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(long totalRow) {
        this.totalRow = totalRow;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

}
