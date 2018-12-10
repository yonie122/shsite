package com.bit.myapp.domain;

import java.sql.Date;

public class FreeBoard {


	
	private int postNo;
	private String ptagName;
	private String ptitle;
	private String pdetail;
	private String writer;
	private Date postDate;
	private Date modiDate;
	private int postNv;
	private int likeCount;
	
	

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPtagName() {
		return ptagName;
	}

	public void setPtagName(String ptagName) {
		this.ptagName = ptagName;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Date getModiDate() {
		return modiDate;
	}

	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}

	public int getPostNv() {
		return postNv;
	}

	public void setPostNv(int postNv) {
		this.postNv = postNv;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	

	@Override
	public String toString() {
		return "FreeBoard [postNo=" + postNo + ", ptagName=" + ptagName + ", ptitle=" + ptitle + ", pdetail=" + pdetail
				+ ", writer=" + writer + ", postDate=" + postDate + ", modiDate=" + modiDate + ", postNv=" + postNv
				+ ", likeCount=" + likeCount + "]";
	}



	private int totalCount;		// 전체 게시물 갯수
	private int pageNum;			// 현재 페이지 번호
	private int contentNum;		// 한 페이지에 게시글을 몇 개 표시 할지
	private int startPage = 1;	// 현재 페이지 블록의 시작 페이지  (게시판에 처음 접속했을 때 처음페이지 = 1페이지)
	private int endPage = 5;		// 현재 페이지 블록의 마지막 페이지 (게시판에 처음 접속했을 때 끝페이지 =  5페이지)
	private boolean prev = false;			// 이전 페이지로 가는 화살표. false일 경우 화살표가 보이지 않음. 게시판 처음 접속 페이지는 1페이지이므로 이전페이지 화살표 false
	private boolean next;			// 다음 페이지로 가는 화살표
	private int currentBlock;		// 현재 페이지 블록
	private int lastBlock;			// 마지막 페이지 블록
	
	
	private int baseRowNum;
	private int endRowNum;
	

	
	public void prevNext (int pageNum) {	// 이전페이지로 가기, 다음페이지로 가기 화살표를 표시해주는 메서드
		
		if(pageNum > 0 && pageNum < 6)  {	// 현제 페이지 넘버가 1~5사이일 경우.. (페이지 블록이 1)
			setPrev(false);							// 이전 블록으로 가는 화살표가 false가 되어 안보이게함. (첫 블록일때만 이전블록으로가는 화살표가 보이지 않음.)
			setNext(true);								// 다음 블록으로 가는 화살표는 true가 되어 보이게함.
		}
		
//		if(pageNum == 1)  {	
//			setPrev(false);							
//			setNext(true);								
//		}	
		
		else if (getLastBlock() == getCurrentBlock()) {
			setPrev(true);
			setNext(false);
		}
		else {
			setPrev(true);
			setNext(true);
		}
		
	}
	
	public int calPage(int totalCount, int contentNum) {	// 총 페이지 갯수를 결정하는 메서드
		// ex ) 전체 게시물 갯수 가 101,  한화면에 보여줄 게시물이 10개라면 총 페이지는 11개가 필요함. 
		//	101/10 = 10.1
		int totalPage = totalCount / contentNum;
		if( totalCount % contentNum > 0) {
			totalPage ++;
//			101/10 = 10.1 = > 11페이지 필요
//			100/10 = 10 페이지
		}
		return totalPage;
	}
	
	public int getBaseRowNum() {
		return baseRowNum;
	}

	public void setBaseRowNum(int baseRowNum) {
		this.baseRowNum = baseRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getContentNum() {
		return contentNum;
	}
	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int currentBlock) {	
		// 페이지 블록으로 시작 페이지를 구함
		this.startPage =  (currentBlock*5) - 4;
	
		// 1 2 3 4 5
		// 6 7 8 9 10
		// 11 12 13
		// 한 페이지 블록마다 페이지가 5개씩 보이게 설정.
		// 현재 페이지 블록을 알게되면 첫 페이지를 알 수 있게 해준다.
		// 현재 페이지 블록이 1일 때  1 2 3 4 5
		// 현재 페이지 블록이 2일 때 6,7,8,9,10
		// 현재 페이지 블록이 3일 때 11 12 13.
		// ex ) 현재 페이지 블록이 2이면 2 * 5 - 4 = 6 이므로 6페이지가 2번 블록의 시작페이지가 된다.

	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int getLastBlock, int getCurrentBlock) {
		
		// 첫 페이지 + 4 하면 마지막 페이지를 알 수 있음.
		// 예외사항: 맨 마지막 페이지는 
		
//		if (getLastBlock == getCurrentBlock)  {
//			if(getStartPage() != 1) {
//				this. endPage = calPage(getTotalCount(), getContentNum())+1;	// 마지막 페이지를 끝 페이지로 저장.
//			}
//			// 현재 페이지 블록이 마지막 페이지 블록이면..
//			else {
//				this. endPage = calPage(getTotalCount(), getContentNum());
//			}
//		}
				if(getLastBlock == getCurrentBlock) {
//			
//			if(getTotalCount()/getContentNum() == 0 ) {
//				
			this. endPage = calPage(getTotalCount(), getContentNum());
		}
//			
//			else {
//				this.endPage =  calPage(getTotalCount(), getContentNum());
//			}
//		}
//		
	else {
			this.endPage = getStartPage()+9;
			}
		
		
//		this.endPage = getStartPage();	
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
	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int pageNum) {
		// 페이지 번호를 통해 페이지 블록을 구한다. 
		// 페이지 번호 / 페이지 그룹 안의 페이지 갯수
		// 현재 페이지가 1p 일 경우 : 1 / 5 = 0.2가 된다.  int로 선언했으므로 0.2는 0이가 된다. 
		// 현재 페이지가 6p 일 경우 : 6 / 5 = 1.2가 된다. 1.2는 1이 된다.
	
		this.currentBlock = pageNum/5;
		if(pageNum%5>0) {
			this.currentBlock++; // 0번블록부터 시작하면 모양새 이상.. 1번블록부터 시작하도록..  ++
		}
		
	}
	public int getLastBlock() {
		return lastBlock;
	}
	
	public void setLastBlock(int totalCount)                                                               {
		// 한 페이지에 보여줄 게시물이 10개, 한 블록에 포함할 페이지가 5페이지로 설정. 
		//  10, 5 = > 10*5 => 50 이 한 블록당 게시할 수 있는 게시물 수가 된다.
		// 전체 게시물 갯수가 125개 라면 125/ 50페이지 블록은 3까지 존재하게 된다.
		this.lastBlock = totalCount / (5*this.contentNum) + 1;
		
		if ( totalCount / (5*this.contentNum) > 0 ) {
			this.lastBlock++;
		}

	}


	
	
}
