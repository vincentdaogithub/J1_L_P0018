package J1_L_P0018.persistance.entity.cd;

import java.io.Serializable;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;

// class for CD
public class CD implements Comparable<CD>, Serializable {
	// serial number
	private static final long serialVersionUID = 06122003L;

	// CD's ID format
	public static final String ID_FORMAT = "^CD-\\d{4}$";

	// constant "unknown" string
	public static final String UNKNOWN = "unknown";

	// format: CD-#### with # as digit
	private String id;

	// collection name (game/movie/music)
	private CDCollectionName cDCollectionName;

	// type
	private CDType type;

	// title
	private String title;

	// unit price
	private float price;

	// publication year
	private int year;

	// empty constructor
	CD() {
		this.id = UNKNOWN;
		this.cDCollectionName = CDCollectionName.UNKNOWN;
		this.type = CDType.UNKNOWN;
		this.title = UNKNOWN;
		this.price = 0;
		this.year = 0;
	}

	// full constructor
	CD(String id, CDCollectionName cDCollectionName, CDType type, String title, float price, int year) {
		this.id = id;
		this.cDCollectionName = cDCollectionName;
		this.type = type;
		this.title = title;
		this.price = price;
		this.year = year;
	}

	// gets, sets ID
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// gets, sets collection name
	public CDCollectionName getCollectionName() {
		return cDCollectionName;
	}

	public void setCollectionName(CDCollectionName cDCollectionName) {
		this.cDCollectionName = cDCollectionName;
	}

	// gets, sets type
	public CDType getType() {
		return type;
	}

	public void setType(CDType type) {
		this.type = type;
	}

	// gets, sets title
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// gets, sets price
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// gets, sets year
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// compares two CDs
	@Override
	public final int compareTo(CD cd) {
		if (cd == null) {
			Logger.log(this.getClass().getName(), Error.COMPARING_NULL_CD.toString());
			throw new NullPointerException(Error.COMPARING_NULL_CD.toString());
		}

		return this.id.compareTo(cd.getId());
	}

	// check CD
	public final boolean check() {
		return CDCheck.check(this);
	}
	
	// clone
	public final CD clone() {
		return new CD(id, cDCollectionName, type, title, price, year);
	}
}
