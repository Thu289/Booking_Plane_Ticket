/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
public class PageInfor {
    private int currentPage, npp, size, numberPage, begin, end, pageStart, pageEnd;

    public PageInfor() {
    }

    public PageInfor(int currentPage, int npp, int size) {
        this.currentPage = currentPage;
        this.npp = npp;
        this.size = size;
    }
    
    public void calculator(){
        numberPage=(size+npp-1)/npp;
        currentPage=currentPage<0?0:currentPage;
        currentPage=currentPage>numberPage-1?numberPage-1:currentPage;
        begin=npp*currentPage;
        begin=(begin<=0)?0:begin;
        end=begin+npp-1;
        end=end>size-1?size-1:end;
        pageStart=currentPage-2;
        pageStart=pageStart>0?pageStart:0;
        pageEnd=currentPage+2;
        pageEnd=pageEnd>numberPage-1?numberPage-1:pageEnd;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getNpp() {
        return npp;
    }

    public int getSize() {
        return size;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int getPageStart() {
        return pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setNpp(int npp) {
        this.npp = npp;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }
    
    
}
