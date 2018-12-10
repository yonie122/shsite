package com.bit.myapp.domain;

public class SearchCriteria {
private String selectTag;

	

	public String getSelectTag() {

		return selectTag;

	}

 

	public void setSelectTag(String selectTag) {

		this.selectTag = selectTag;

	}

 

	private String searchType;

 

	private String keyword;

 

	public String getSearchType() {

 

		return searchType;

 

	}

 

	public void setSearchType(String searchType) {

 

		this.searchType = searchType;

 

	}

 

	public String getKeyword() {

 

		return keyword;

 

	}

 

	public void setKeyword(String keyword) {

 

		this.keyword = keyword;

 

	}

 

	@Override

	public String toString() {

		return "SearchCriteria [selectTag=" + selectTag + ", searchType=" + searchType + ", keyword=" + keyword + "]";

	}

 
}
