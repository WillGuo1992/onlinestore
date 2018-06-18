package domain;

import java.util.List;

/**
 * @description: 分页
 * @author: Will.Guo
 * @create: 2018-06-14 15:10
 **/
public class PageBean <T> {
    private int pageNumber;
    private int pageSize;

    private int totalRecord;
    private int totalPage;
    private int startIndex;
    private List<T> data;
    private String url;
    private int prePageNum;
    private int nextPageNum;


    public PageBean(int pageNumber, int pageSize, int totalRecord) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalRecord = totalRecord;

        this.totalPage = ( this.totalRecord + this.pageSize -1 ) / this.pageSize;
        this.startIndex = ( this.pageNumber -1 ) * pageSize;
    }


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrePageNum() {
        return pageNumber>1?(pageNumber-1):1;
    }


    public int getNextPageNum() {

        return pageNumber<totalPage?pageNumber+1:totalPage;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }
}



