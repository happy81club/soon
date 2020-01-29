package com.sbt.web.dto;

/**
 * 
 * @author https://doublesprogramming.tistory.com/199
 *
 */
public class Criteria {
	// ������ ��ȣ
    private int page;
    // ������ �� �Խù� ����
    private int perPageNum;

    // �⺻������ : 1������, ������ �� �Խù� ���� 10���� �ʱ�ȭ
    public Criteria() {
        this.page       = 1;
        this.perPageNum = 10;
    }

    // ������ ��ȣ ��ȿ�� üũ
    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    // ������ �� �Խù� ���� ��ȿ�� üũ
    public void setPerPageNum(int perPageNum) {
        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
            return;
        }
        this.perPageNum = perPageNum;
    }

    public int getPage() {
        return page;
    }


    // for MyBatis SQL Mapper
    public int getPerPageNum() {
        return this.perPageNum;
    }

    // for MyBatis SQL Mapper
    // ������ �� ���۹�ȣ
    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }
   
}
