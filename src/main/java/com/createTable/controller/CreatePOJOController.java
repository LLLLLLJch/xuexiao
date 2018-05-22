package com.createTable.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createTable.pojo.Table;

@Controller
@RequestMapping("/createPOJOIndex")
public class CreatePOJOController {

	@RequestMapping("goPage")
	public String goPage() {
		return "pojo_list";
	}

	@RequestMapping("CreatePOJO")
	public String CreateTableSQL(String table,Model model,String tableName) {
		List<Table> tables = new ArrayList<Table>();
		String[] strings = table.split(" ");
		for (String string : strings) {
			int i = 0;
			Table table2 = new Table();
			String[] str = string.split("	");
			for (String string2 : str) {
				i++;
				if (i == 1) {
					table2.setID(string2);
				}
				if (i == 2) {
					table2.setType(string2);
				}
				if (i == 3) {
					table2.setLength(string2);
				}
				if (i == 4) {
					table2.setName(string2);
				}
				if (i == 5) {
					table2.setIsEmpty(string2);
				}
				if (i == 6) {
					table2.setMajorKey(string2);
				}
				if (i == 7) {
					table2.setForeignKey(string2);
				}
				if (i == 8) {
					if(string2.equals("")) {
						table2.setLinkTable("");
					}else {
						table2.setLinkTable(string2);
					}
				}
			}
			tables.add(table2);
		}
		String pojo = "";
		for (Table string : tables) {
			System.out.println(string);
			if(string.getType().equals("varchar")) {
				pojo = pojo+"private String "+string.getID()+";";
			}
			if(string.getType().equals("int")) {
				pojo = pojo+"private Integer "+string.getID()+";";
			}
			if(string.getType().equals("date")) {
				pojo = pojo+"private Date "+string.getID()+";";
			}
		}
		model.addAttribute("pojo", pojo);
		model.addAttribute("table", table);
		return "pojo_list";
	}
}
