package com.createTable.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createTable.pojo.Table;

@Controller
@RequestMapping("/createTableIndex")
public class CreateTableController {

	@RequestMapping("goPage")
	public String goPage() {
		return "machine_list";
	}

	@RequestMapping("CreateTableSQL")
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
		Map<Object, String> map = new HashMap<Object,String>();
		int a = 0;
		for (Table string : tables) {
			a++;
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+" "+ "PRIMARY KEY AUTO_INCREMENT COMMENT "+"'"+string.getName()+"'");
			}
			
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+" "+ "PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT "+"'"+string.getName()+"'");
			}
			
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+"COMMENT "+"'"+string.getName()+"'");
			}
			
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+" "+ "NOT NULL COMMENT "+"'"+string.getName()+"'");
			}
			
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") "+ "PRIMARY KEY AUTO_INCREMENT COMMENT "+"'"+string.getName()+"'");
			}
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") "+ "PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT"+"'"+string.getName()+"'");
			}
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") COMMENT "+"'"+string.getName()+"'");
			}
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("NO")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") NOT NULL COMMENT "+"'"+string.getName()+"'");
			}
			/*----------------------------*/
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+" "+ "PRIMARY KEY AUTO_INCREMENT COMMENT "+"'"+string.getName()+"'"+","+
				"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+""
						);
			}
			
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+" "+ "PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT "+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
			
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+"COMMENT "+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
			
			if(!string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+" "+ "NOT NULL COMMENT "+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
			
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") "+ "PRIMARY KEY AUTO_INCREMENT COMMENT "+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("Yes") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") "+ "PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT"+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("Yes") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") COMMENT "+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
			if(string.getType().equals("varchar") && string.getIsEmpty().equals("NO") && string.getMajorKey().equals("NO") && string.getForeignKey().equals("Yes")) {
				map.put(a, string.getID()+" "+string.getType()+"("+string.getLength()+") NOT NULL COMMENT "+"'"+string.getName()+"'"+","+
						"foreign key("+string.getID()+") REFERENCES "+string.getLinkTable()+"");
			}
		}
		String sql = "";
		for(int b = 1;b <= map.size();b++) {
			sql =sql+map.get(b)+",";
		}
		String SQL = "create table "+tableName+"(" +
				sql
				 +");";
		model.addAttribute("SQL", SQL);
		model.addAttribute("tableName", tableName);
		model.addAttribute("table", table);
		return "machine_list";
	}
}
