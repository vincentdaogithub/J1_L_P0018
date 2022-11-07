package J1_L_P0018.persistance.entity.cd;

import java.io.Serializable;

import J1_L_P0018.persistance.error.Error;
import J1_L_P0018.log.Logger;


// class for CD
public class CD implements Comparable<CD>, Serializable
{
	// serial number
	private static final long serialVersionUID = 06122003L;

	
	// format: CD-#### with # as digit
	private String id;
	
	// collection name (game/movie/music)
	private CollectionName collectionName;
	
	// type
	private CDType type;
	
	// unit price
	private float price;
	
	// publication year
	private int year;
	
	
	// empty constructor
	public CD()
	{
		this.id = "";
		this.collectionName = CollectionName.UNKNOWN;
		this.type = CDType.UNKNOWN;
		this.price = 0;
		this.year = 0;
	}
	
	
	// full constructor
	public CD(String id, CollectionName collectionName, CDType type, float price, int year)
	{
		this.id = id;
		this.collectionName = collectionName;
		this.type = type;
		this.price = price;
		this.year = year;
	}


	// gets, sets ID
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}


	// gets, sets collection name
	public CollectionName getCollectionName()
	{
		return collectionName;
	}

	public void setCollectionName(CollectionName collectionName)
	{
		this.collectionName = collectionName;
	}


	// gets, sets type
	public CDType getType()
	{
		return type;
	}

	public void setType(CDType type)
	{
		this.type = type;
	}


	// gets, sets price
	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}


	// gets, sets year
	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}


	// compares two CDs
	@Override
	public final int compareTo(CD cd)
	{
		if (cd == null)
		{
			Logger.log(this.getClass().getName(), Error.COMPARING_NULL_CD.toString());
			throw new NullPointerException(Error.COMPARING_NULL_CD.toString());
		}
		
		return this.id.compareTo(cd.getId());
	}
}
