/**
 * The Linux Directory Structure Project
 * Java Project SimpleConsole
 * Copyright 2020 PeTrA. All rights reserved.
 */

/**
 * LinuxDirectoryStructure/SimpleConsole/src/simpleConsole/Main.java
 */
package simpleConsole;

import java.util.Scanner;

import dataStructure.LinkedList;
import dataStructure.Node;
import dataStructure.Tree;

/**
 * Main Class.
 */
public class Main {
	public static void main(String[] args){
		System.out.println("The Linux Directory Structure Project");
		System.out.println("Copyright 2020 PeTrA. All rights reserved.");
		System.out.println("");
		/**
		 * Local Value.
		 * 
		 * simpleConsole : basic tree
		 * command : command
		 * keyword_1 : main command
		 * keyword_2 : parameter
		 * scan : Scanner instance
		 * locationNode : Now, in the Node.
		 **/
		Tree simpleConsole = new Tree();
		String command = "";
		String keyword_1 = "";
		String keyword_2 = "";
		Scanner scan = new Scanner(System.in);
		Node locationNode = new Node();
		
		locationNode = simpleConsole.getRoot();

		while(true){
			System.out.print("root@ChoHeeGwon~/" + locationNode.getName() + "# ");
			command = "";
			keyword_1 = "";
			keyword_2 = "";
			command = scan.nextLine();
			int key = command.length(); // temp
			
			for(int i = 0; i < command.length(); i++){
				if(command.charAt(i) == ' '){
					key = i + 1;
					break;
				}
			}
			if(key != command.length()){
				for(int i = 0; i < key -1; i++){
					keyword_1 = keyword_1 + command.charAt(i);
				}
				for(int i = key; i < command.length(); i++){
					keyword_2 = keyword_2 + command.charAt(i);
				}
			}else{
				keyword_1 = command;
			}
			
			if(keyword_1.equals("ls")){
				locationNode.printAll();
			}else if(keyword_1.equals("pwd")){
				LinkedList pwdList = new LinkedList(null);
				Node tempNode = new Node();
				tempNode = locationNode;
				
				while(true){
					pwdList.add(tempNode.getName());
					if(tempNode.getName().equals("root")){
						break;
					}
					tempNode = tempNode.getParentNode();
				}
				
				System.out.print("/");
				
				for(int i = pwdList.getLength()-1; i >= 0; i--){
					System.out.print(pwdList.getNodeName(i));
					System.out.print("/");
				}
				System.out.println("");
			}else if(keyword_1.equals("cd")){
				if(keyword_2.equals("..")){
					if(locationNode.getParentNode() != null){
						locationNode = locationNode.getParentNode();
					}
				}else{
					int tempNumber = locationNode.getChildList().getLength();

					for(int i = 0; i < tempNumber; i++){
						if(keyword_2.equals(locationNode.getChildList().getNodeName(i))){
							locationNode = locationNode.getChildList().getNode(keyword_2);
							break;
						}
					}
				}
			}else if(keyword_1.equals("mkdir")){
				locationNode.addChild(keyword_2, locationNode);
			}else if(keyword_1.equals("rm")){
				if(locationNode.getChildList().getLength() > 0){
					int kyu = locationNode.getChildList().getLength(); // temp
					for(int i = 0; i < kyu; i++){
						if(keyword_2.equals(locationNode.getChildList().getNodeName(i))){
							locationNode.deleteChild(keyword_2);
							break;
						}
					}
				}
			}
		}
	}
}
