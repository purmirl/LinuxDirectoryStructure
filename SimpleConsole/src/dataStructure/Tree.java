/**
 * The Linux Directory Structure Project
 * Java Project SimpleConsole
 * Copyright 2020 PeTrA. All rights reserved.
 */

/**
 * LinuxDirectoryStructure/SimpleConsole/src/dataStructure/Tree.java
 */
package dataStructure;

/**
 * Class Tree.
 */
public class Tree {
	private Node root;
	
	public Tree(){
		this.root = new Node();
		this.root.setName("root");
	}
	
	public Node getRoot(){
		return this.root;
	}
	
}
