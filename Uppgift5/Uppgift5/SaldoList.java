package Uppgift5;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SaldoList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static TableView getList() {
		TableColumn plusAndMinus = new TableColumn("Inkomster/Uttag");
		plusAndMinus.setMinWidth(160);
		TableColumn saldo = new TableColumn("Saldo"); 
		saldo.setMinWidth(160);
		
		TableView list = new TableView();
		list.setMaxHeight(300);
		list.setMaxWidth(320);
		list.getColumns().addAll(plusAndMinus, saldo);		
		
		return list;
	}  

}
