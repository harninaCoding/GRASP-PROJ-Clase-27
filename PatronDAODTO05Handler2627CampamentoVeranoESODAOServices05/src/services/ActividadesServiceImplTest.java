package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ActividadesServiceImplTest {

	@Test
	void testGetActividadesByMonitor() {
		ActividadesService actividadesService=new ActividadesServiceImpl();
		actividadesService.getActividadesByMonitor("11111111A");
	}

}
