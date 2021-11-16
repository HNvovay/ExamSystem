package com.common;

import java.sql.SQLException;
import java.util.List;

import com.model.Mchoose;
import com.model.Schoose;

public class Paging {
	int PageSize;
	//设置欲显示的页数(初始页)
	int ShowPage;
	//ResultSet的记录笔数(总记录数)
	int RowCount;
	//ResultSet分页后的总数(总页数)
	int PageCount;
	String ToPage=null;
	List list=null;
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Paging() {
		// TODO Auto-generated constructor stub
		PageSize=10;
		//设置欲显示的页数(初始页)
		ShowPage=1;
		//ResultSet的记录笔数(总记录数)
		RowCount=0;
		//ResultSet分页后的总数(总页数)
		PageCount=0;
		
	}
	
	public void Pnum(){
		
			//获取记录总数
			RowCount=list.size();
			//计算显示的页数(关键)
			PageCount=((RowCount%PageSize)==0?(RowCount/PageSize):(RowCount/PageSize)+1);
		
	}
	public void judge(){
		

		if(ToPage!=null)
		{
		//取得指定显示的分页页数
		ShowPage=Integer.parseInt(ToPage);
		//下面的语句判断用户输入的页数是否正确
		if(ShowPage>=PageCount)
		{
		ShowPage=PageCount;
		}
		else if(ShowPage<=0)
		{
		ShowPage=1;
		}
		}
		list=list.subList(PageSize*(ShowPage-1), list.size());
		
	}
	public void entryjudge(){
		
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public int getShowPage() {
		return ShowPage;
	}
	public void setShowPage(int showPage) {
		ShowPage = showPage;
	}
	public int getRowCount() {
		return RowCount;
	}
	public void setRowCount(int rowCount) {
		RowCount = rowCount;
	}
	public int getPageCount() {
		return PageCount;
	}
	public void setPageCount(int pageCount) {
		PageCount = pageCount;
	}
	public String getToPage() {
		return ToPage;
	}
	public void setToPage(String toPage) {
		ToPage = toPage;
	}	
}
