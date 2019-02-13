package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy {

	private int pageNum, pageSize, blockSize, startRow, endRow, startpage, endpage, prevBlock, nextBlock, totalCount;

	private boolean existPrev, existNext;

	@Override
	public void carryOut(Object o) {

		HttpServletRequest request = (HttpServletRequest) o;

		String _pageNum = request.getParameter("page_num");
		pageNum = (request.getParameter("page_num") == null) ? 1 : Integer.parseInt(_pageNum);
		System.out.println("페이지네이션 페이지넘" + pageNum);

		String _pageSize = request.getParameter("page_size");
		pageSize = (request.getParameter("page_size") == null) ? 5 : Integer.parseInt(_pageSize);
		System.out.println("페이지네이션 페이지넘" + pageSize);
		
		String _blockSize = request.getParameter("block_Size");
		blockSize = (request.getParameter("block_Size") == null)? 5 : Integer.parseInt(_blockSize);

		totalCount = CustomerServiceImpl.getInstance().countCustomer(null);
		System.out.println("전체 카운터" + totalCount);

		int pageCount = totalCount / pageSize;
		System.out.println("총페이지 수:"+pageCount);
		
		startRow = (pageNum - 1) * pageSize + 1;
		System.out.println("스타트 로우:"+startRow);
		
		endRow = (totalCount>pageNum*pageSize)?pageNum*pageSize:totalCount;
		System.out.println("END로우:"+endRow);
		

		System.out.println("start ROW::" + startRow);
		System.out.println("END ROW::" + endRow);

	

	}

}
