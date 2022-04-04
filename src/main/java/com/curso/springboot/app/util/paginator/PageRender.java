package com.curso.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;

	private int total;
	private int perPage;
	private int current;

	private List<PageItem> pages;

	public PageRender(String url, Page<T> page) {

		this.url = url;
		this.page = page;

		this.pages = new ArrayList<PageItem>();

		perPage = page.getSize();
		total = page.getTotalPages();
		current = page.getNumber() + 1;

		int from, to;
		if (total <= perPage) {
			from = 1;
			to = total;
		} else {
			if (current <= (perPage / 2)) {
				from = 1;
				to = perPage;
			} else if (current >= total - perPage / 2) {
				from = (total - perPage) + 1;
				to = perPage;
			} else {
				from = current - (perPage / 2);
				to = total;
			}
		}

		for (int i = 0; i < to; i++) {
			pages.add(new PageItem(from + i, current == from + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrent() {
		return current;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {
		return page.hasNext();
	}

	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
