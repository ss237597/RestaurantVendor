public class CategoryNode <T>{
	T element;
	CategoryNode <T> link;
	public CategoryNode(T element) {
		super();
		this.element = element;
		this.link = null;
	}
	public CategoryNode(T element, CategoryNode <T> link) {
		super();
		this.element = element;
		this.link = link;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public CategoryNode <T> getLink() {
		return link;
	}
	public void setLink(CategoryNode <T>link) {
		this.link = link;
	}
}
