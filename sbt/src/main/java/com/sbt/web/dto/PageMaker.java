package com.sbt.web.dto;

/**
 * 
 * @author https://doublesprogramming.tistory.com/199
 * 
 */
public class PageMaker {

    private int totalCount;  // ��ü �Խñ��� ����
    private int startPage;   // ���� ������ ��ȣ
    private int endPage;     // �� ������ ��ȣ
    private boolean prev;    // ������ũ
    private boolean next;    // ������ũ

    private int displayPageNum = 10;  // �ϴ��� ������ ��ȣ�� ������ �ǹ�

    private Criteria criteria;

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }
    
    // �Խñ��� ��ü ������ �����Ǵ� ������ ȣ���Ͽ� �ʿ��� �����͵� ����Ѵ�.
    private void calcData() {

        endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;

        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;

    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }

    public Criteria getCriteria() {
        return criteria;
    }

}