package com.vergelmercado.application.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1; // database version
	private static final String DATABASE_NAME = "DatabaseName"; // database name

	public DatabaseAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	/*private static final int DATABASE_VERSION = 1; // database version
	private static final String DATABASE_NAME = "ScannerDb"; // database name

	// table and columns here
	private static final String TABLE_FMNS = "tbl_fmns";
	private static final String FMNS_ID = "fmns_id";
	private static final String FMNS_ASSETTAG = "fmns_assettag";
	private static final String FMNS_DATA = "fmns_data";


	public DatabaseAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// TODO Auto-generated method stub

		String create_tbl_fmns = "CREATE TABLE " + TABLE_FMNS + "(" + FMNS_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
				+ FMNS_ASSETTAG + " TEXT," + FMNS_DATA + " TEXT NOT NULL" + ")";

		db.execSQL(create_tbl_fmns);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_FMNS);
		// Create tables again
		onCreate(db);
	}


	private String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}


	public void addCubicle(CubicleModel qr) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(cubicle, qr.getType());
		values.put(location, qr.getLocation());
		values.put(nodePrimary, qr.getNodeP());
		values.put(nodeSecondary, qr.getNodeS());
		values.put(nodeVoice, qr.getNodeV());
		values.put(createdDate, qr.getCreatedDate());
		values.put(uploadedDate, qr.getUploadedDate());
		values.put(cFacilityId, qr.getFacilityId());

		// Inserting Row
		db.insert(TABLE_CUBICLE, null, values);
		db.close(); // Closing database connection
	}


	public List<StationModel> getAllAssets() {
		List<StationModel> stationList = new ArrayList<StationModel>();
		String selectQuery = "SELECT * FROM " + TABLE_NEWSTATION;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				StationModel station = new StationModel(cursor.getString(1),
						cursor.getString(2), cursor.getString(3),
						cursor.getString(4), cursor.getString(5),
						cursor.getString(6), cursor.getString(7),
						cursor.getString(8), cursor.getString(9),
						cursor.getString(10));

				station.setQType(cursor.getString(1));
				station.setTag(cursor.getString(2));
				station.setPo(cursor.getString(3));
				station.setStartDate(cursor.getString(4));
				station.setQBu(cursor.getString(5));
				station.setCubicleNumber(cursor.getString(6));
				station.setStaticIP(cursor.getString(7));
				station.setNodeTerminated(cursor.getString(8));
				station.setQCreatedDate(cursor.getString(9));
				station.setQUploadedDate(cursor.getString(10));

				// Adding fmsn to list
				stationList.add(station);
			} while (cursor.moveToNext());
		}
		cursor.close();

		return stationList;
	}


	public List<JoinModel> getAllData() {
		List<JoinModel> stationList = new ArrayList<JoinModel>();
		// Select All Query
		// String selectQuery = "SELECT  * FROM " + TABLE_NEWSTATION
		// + " LEFT JOIN " + TABLE_CUBICLE + "  ON " + TABLE_NEWSTATION
		// + "." + cubicleID + "=" + TABLE_CUBICLE + "." + cubicleNo;

		String selectQuery = "SELECT  * FROM " + TABLE_CUBICLE
				+ "  INNER JOIN " + TABLE_NEWSTATION + "  ON " + TABLE_CUBICLE
				+ "." + location + " = " + TABLE_NEWSTATION + "." + cubicleID;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				JoinModel station = new JoinModel(cursor.getString(1),
						cursor.getString(2), cursor.getString(3),
						cursor.getString(4), cursor.getString(5),
						cursor.getString(10), cursor.getString(11),
						cursor.getString(12), cursor.getString(13),
						cursor.getString(14), cursor.getString(6),
						cursor.getString(7), cursor.getString(18),
						cursor.getString(19),cursor.getString(8));

				station.setQType(cursor.getString(10));
				station.setTag(cursor.getString(11));
				station.setPo(cursor.getString(12));
				station.setStartDate(cursor.getString(13));
				station.setQBu(cursor.getString(14));
				station.setQCreatedDate(cursor.getString(18));
				station.setQUploadedDate(cursor.getString(19));
				station.setType(cursor.getString(1));
				station.setLocation(cursor.getString(2));
				station.setNodeP(cursor.getString(3));
				station.setNodeS(cursor.getString(4));
				station.setNodeV(cursor.getString(5));
				station.setCreatedDate(cursor.getString(6));
				station.setUploadedDate(cursor.getString(7));
				station.setfacilityId(cursor.getString(8));

				// Adding fmsn to list
				stationList.add(station);
			} while (cursor.moveToNext());
		}
		cursor.close();

		return stationList;
	}

	// delete here
	public void deleteCubicleSubData(String cubicle) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NEWSTATION, cubicleID + " = '" + cubicle + "'", null);
		// db.delete(TABLE_STATION, null, null);
		db.close();
	}

	// delete entry
	// Deleting single contact
	public void deleteStation() {
		SQLiteDatabase db = this.getWritableDatabase();
		// db.delete(TABLE_STATION, KEY_ID + " = ?",
		// new String[] { String.valueOf(contact.getID()) });
		db.delete(TABLE_STATION, null, null);
		db.close();
	}


	//

	// //////////////////////////////////////////////////*/

}
