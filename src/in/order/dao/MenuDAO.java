package in.order.dao;

import java.util.List;
import in.order.entity.MenuInfo;

public interface MenuDAO {
	List<MenuInfo> getMenu();
	MenuInfo getItem(int itemId);
}
