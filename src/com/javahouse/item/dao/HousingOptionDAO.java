package com.javahouse.item.dao;

import java.util.ArrayList;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.item.vo.HousingOptionVO;

public class HousingOptionDAO implements GenericDAO<HousingOptionVO, Integer> {

	@Override
	public void insert(final HousingOptionVO vo) throws Exception {
		final String SQL_QUERY = "INSERT INTO HousingOption "
				+ "(item_id, has_TV, has_refrigerator, has_microwave, has_bed, bed_cnt, has_bathroom, is_public_bathroom, "
				+ "has_ac, has_washing_machine, has_kitchen) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setInt(1, vo.getItemID());

				stmt.setBoolean(2, vo.isHasTV());
				stmt.setBoolean(3, vo.isHasRefrigerator());
				stmt.setBoolean(4, vo.isHasMicrowave());
				
				stmt.setBoolean(5, vo.isHasBed());
				stmt.setInt(6, vo.getBedCnt());
				
				stmt.setBoolean(7, vo.isHasBathroom());
				stmt.setBoolean(8, vo.isPublicBathroom());
				
				stmt.setBoolean(9, vo.isHasAC());
				stmt.setBoolean(10, vo.isHasWashingMachine());
				stmt.setBoolean(11, vo.isHasKitchen());
				
				stmt.executeUpdate();
			}
		}.execute();
	}

	@Override
	public void update(final HousingOptionVO vo) throws Exception {
		final String SQL_QUERY = "UPDATE HousingOption SET "
				+ "has_TV = ?, has_refrigerator = ?, has_microwave = ?, has_bed = ?, bed_cnt = ?, "
				+ "has_bathroom = ?, is_public_bathroom = ?, has_ac = ?, has_washing_machine = ?, has_kitchen = ? "
				+ "WHERE item_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);

				stmt.setBoolean(1, vo.isHasTV());
				stmt.setBoolean(2, vo.isHasRefrigerator());
				stmt.setBoolean(3, vo.isHasMicrowave());
				
				stmt.setBoolean(4, vo.isHasBed());
				stmt.setInt(5, vo.getBedCnt());
				
				stmt.setBoolean(6, vo.isHasBathroom());
				stmt.setBoolean(7, vo.isPublicBathroom());
				
				stmt.setBoolean(8, vo.isHasAC());
				stmt.setBoolean(9, vo.isHasWashingMachine());
				stmt.setBoolean(10, vo.isHasKitchen());
				
				stmt.setInt(11, vo.getItemID());
				
				stmt.executeUpdate();
			}
		}.execute();
	}

	@Override
	public void delete(final Integer key) throws Exception {
		throw new Exception();
	}

	@Override
	public HousingOptionVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM HousingOption "
				+ "WHERE item_id = ?";
		
		HousingOptionVO vo = new HousingOptionVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setItemID(rs.getInt(1));
					vo.setHasTV(rs.getBoolean(2));
					vo.setHasRefrigerator(rs.getBoolean(3));
					vo.setHasMicrowave(rs.getBoolean(4));
					
					vo.setHasBed(rs.getBoolean(5));
					vo.setBedCnt(rs.getInt(6));
					
					vo.setHasBathroom(rs.getBoolean(7));
					vo.setPublicBathroom(rs.getBoolean(8));
					
					vo.setHasAC(rs.getBoolean(9));
					vo.setHasWashingMachine(rs.getBoolean(10));
					vo.setHasKitchen(rs.getBoolean(11));
				}	
			}
		}.execute();
		
		return vo;
	}
	
	public HousingOptionVO[] getAllRows() throws Exception {
		final String SQL_QUERY = "SELECT * FROM HousingOption";
		
		ArrayList<HousingOptionVO> voArr = new ArrayList<HousingOptionVO>();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					HousingOptionVO vo = new HousingOptionVO();
					
					vo.setItemID(rs.getInt(1));
					vo.setHasTV(rs.getBoolean(2));
					vo.setHasRefrigerator(rs.getBoolean(3));
					vo.setHasMicrowave(rs.getBoolean(4));
					
					vo.setHasBed(rs.getBoolean(5));
					vo.setBedCnt(rs.getInt(6));
					
					vo.setHasBathroom(rs.getBoolean(7));
					vo.setPublicBathroom(rs.getBoolean(8));
					
					vo.setHasAC(rs.getBoolean(9));
					vo.setHasWashingMachine(rs.getBoolean(10));
					vo.setHasKitchen(rs.getBoolean(11));
					
					voArr.add(vo);
				}	
			}
		}.execute();
		
		return voArr.toArray(new HousingOptionVO[voArr.size()]);
	}
}