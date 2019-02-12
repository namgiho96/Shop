package proxy;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements capable {
	private String pageNum, pageSize, blockSize, startRow, endRow, startpage, endpage, prevBlock, nextBlock;
	private int totalCount;
	private boolean existPrev, existNext;

	@Override
	public void carryOut() {
		// 디폴트값 만드는 방법
		HttpServletRequest request = Receiver.cmd.getRequest();

		this.pageNum = (request.getParameter("page_num") == null) ? "1" : request.getParameter("page_num");
		System.out.println("페이지네이션 페이지넘" + pageNum);
		this.pageSize = (request.getParameter("page_size") == null) ? "5" : request.getParameter("page_size");
		System.out.println("페이지네이션 페이지넘" + pageSize);
		this.totalCount = CustomerServiceImpl.getInstance().countCustomer();

		System.out.println("TOTAL" + this.totalCount);

		this.startRow = String.valueOf(totalCount - (Integer.parseInt(pageSize) * Integer.parseInt(pageNum)) + 1);
		this.endRow = String.valueOf(totalCount - (Integer.parseInt(pageSize) * (Integer.parseInt(pageNum) - 1)));

		System.out.println("start ROW::" + startRow);
		System.out.println("END ROW::" + endRow);

		// total count
		// pagenum
		// start

	}
}
