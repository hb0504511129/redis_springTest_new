package org.buzheng.mybatis.pageable;

public class PostgreSQLDialect extends Dialect {

	public boolean supportsLimitOffset(){
		return true;
	}
	
    public boolean supportsLimit() {   
        return true;   
    }
    
	protected String getLimitString(String sql, String offsetName, int offset,
			String limitName, int limit) {
		StringBuffer buffer = new StringBuffer(sql.length() + 20).append(sql);
		if (offset > 0) {
			buffer.append(sql).append(" ");
			buffer.append("limit").append(" ");
			buffer.append(limitName).append(" ");
			buffer.append("offset").append(" ");
			buffer.append(offsetName).append(" ");
//			buffer.append(" limit ? offset ?");
//			setPageParameter(limitName, Integer.valueOf(limit), Integer.class);
//			setPageParameter(offsetName, Integer.valueOf(offset), Integer.class);
			
		} else {
			
			buffer.append(sql).append(" ");
			buffer.append("limit").append(" ");
			buffer.append(limitName).append(" ");
//			buffer.append(" limit ?");
//			setPageParameter(limitName, Integer.valueOf(limit), Integer.class);
		}
		return buffer.toString();
	}

}
