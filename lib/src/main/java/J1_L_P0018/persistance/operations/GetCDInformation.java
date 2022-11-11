package J1_L_P0018.persistance.operations;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;

public class GetCDInformation {
	// get cd information
	public static final String get(CD cd) {
		if (cd == null) {
			Logger.log(Error.NULL_CD.toString());
			throw new NullPointerException(Error.NULL_CD.toString());
		}

		StringBuilder builder = new StringBuilder();
		builder.append(cd.getId());
		builder.append(' ');
		builder.append(cd.getCollectionName().toString());
		builder.append(' ');
		builder.append(cd.getType());
		builder.append(" \"");
		builder.append(cd.getTitle());
		builder.append("\" ");
		builder.append(String.format("%.2f$", cd.getPrice()));
		builder.append(' ');
		builder.append(cd.getYear());

		return builder.toString();
	}
}
