package Uppgift5;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SaldoList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static TableView getList() {
		TableColumn plus = new TableColumn("Inkomster");
		plus.setMinWidth(166);
		TableColumn minus = new TableColumn("Utgifter"); 
		minus.setMinWidth(166);
		TableColumn saldo = new TableColumn("Saldo"); 
		saldo.setMinWidth(166);
		
		TableView list = new TableView();
		list.setMaxHeight(300);
		list.setMaxWidth(500);
		list.getColumns().addAll(plus, minus, saldo);		
		
		return list;
	}  

}
