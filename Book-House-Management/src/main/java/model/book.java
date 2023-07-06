package model;

public class book {
	    protected int id;
	    protected String name;
	    protected int edition;
	    protected double price;

	    public book() {}

	    public book(String name, int edition, double price) {
	        super();
	        this.name = name;
	        this.edition = edition;
	        this.price = price;
	    }
	    public book(int id, String name, int edition, double price) {
	        super();
	        this.id=id;
	        this.name = name;
	        this.edition = edition;
	        this.price = price;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getEdition() {
			return edition;
		}

		public void setEdition(int edition) {
			this.edition = edition;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

	   
	
}
