/**
 * The Linux Directory Structure Project
 * Java Project SimpleConsole
 * Copyright 2020 PeTrA. All rights reserved.
 */

/**
 * LinuxDirectoryStructure/SimpleConsole/src/dataStructure/Node.java
 */
package dataStructure;

/**
 * Class Node.
 */
public class Node {
	private String name;
	private Node prevNode;
	private Node nextNode;
	private Node parentNode;

	private LinkedList childList;
	
	private boolean child;
	public Node(){
		this.name = "";
		this.prevNode = null;
		this.nextNode = null;
		this.parentNode = null;
		this.childList = null;
		this.child = false;
	}
	
	public void setPrevNode(Node _prevNode){
		this.prevNode = _prevNode;
	}
	
	public void setNextNode(Node _nextNode){
		this.nextNode = _nextNode;
	}
	
	public void addChild(String _name, Node _node){
		if(this.childList == null){
			this.childList = new LinkedList(_node);
		}
		this.childList.add(_name);
		this.child = true;
	}
	
	public void deleteChild(String _name){
		this.childList.delete(_name);
	}
	
	public void setName(String _name){
		this.name = _name;
	}
	
	public void setParentNode(Node _node){
		this.parentNode = _node;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Node getPrevNode(){
		return this.prevNode;
	}
	
	public Node getNextNode(){
		return this.nextNode;
	}
	
	public Node getParentNode(){
		return this.parentNode;
	}
	
	public LinkedList getChildList(){
		return this.childList;
	}
	
	public void printAll(){
		if(this.childList == null){
			return;
		}
		this.childList.printAll();
	}
}
