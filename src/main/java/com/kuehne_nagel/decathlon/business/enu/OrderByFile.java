package com.kuehne_nagel.decathlon.business.enu;
/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public enum OrderByFile {
	OBF_MTS100(1, ScoringTable.ST_MTS100), 
	OBF_LONGJUMP(2, ScoringTable.ST_LONGJUMP), 
	OBF_SHOTPUT(3, ScoringTable.ST_SHOTPUT), 
	OBF_HIGHJUMP(4, ScoringTable.ST_HIGHJUMP), 
	OBF_MTS400(5, ScoringTable.ST_MTS400), 
	OBF_HURDLESMTS110(6, ScoringTable.ST_HURDLESMTS110),
	OBF_DISCUSTHROW(7, ScoringTable.ST_DISCUSTHROW), 
	OBF_POLEVAULT(8, ScoringTable.ST_POLEVAULT), 
	OBF_JAVELINTHROW(9, ScoringTable.ST_JAVELINTHROW), 
	OBF_MTS1500(10, ScoringTable.ST_MTS1500);

	private int positionFile;
	private ScoringTable scoringTable;

	/**
	 * @param positionFile
	 * @param scoringTable
	 */
	private OrderByFile(int positionFile, ScoringTable scoringTable) {
		this.positionFile = positionFile;
		this.scoringTable = scoringTable;
	}

	public int getPositionFile() {
		return positionFile;
	}

	public void setPositionFile(int positionFile) {
		this.positionFile = positionFile;
	}

	public ScoringTable getScoringTable() {
		return scoringTable;
	}

	public void setScoringTable(ScoringTable scoringTable) {
		this.scoringTable = scoringTable;
	}

}
