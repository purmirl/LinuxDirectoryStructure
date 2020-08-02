/**
 * The Linux Directory Structure Project
 * Java Project SimpleConsole
 * Copyright 2020 PeTrA. All rights reserved.
 */

/**
 * LinuxDirectoryStructure/SimpleConsole/src/dataStructure/LinkedList.java
 */
package dataStructure;

/**
 * Class LinkedList
 */
public class LinkedList {
	private Node headNode;
	private Node tailNode;
	private Node parentNode;
	private int length;
	
	public LinkedList(Node _parentNode){
		init(_parentNode);
	}
	
	public void setParentNode(Node _node){
		this.parentNode = _node;
	}
	
	private void init(Node _parentNode){
		this.headNode = new Node();
		this.tailNode = new Node();
		this.headNode.setNextNode(this.tailNode);
		this.tailNode.setPrevNode(this.headNode);
		this.length = 0;
		this.parentNode = _parentNode;
	}
	
	public void add(String _name){
		Node tempNode = new Node();
		tempNode = this.headNode;
		for(int i = 0; i < length; i++){
			tempNode = tempNode.getNextNode();
			/**
			 * If there is a same name...
			 */
			if(tempNode.getName().equals(_name)){
				return;
			}
		}
		tempNode = new Node();
		tempNode.setName(_name);
		tempNode.setParentNode(this.parentNode);
		if(this.length == 0){
			this.headNode.setNextNode(tempNode);
			tempNode.setPrevNode(this.headNode);
			this.tailNode.setPrevNode(tempNode);
			tempNode.setNextNode(this.tailNode);
		}else{
			this.tailNode.getPrevNode().setNextNode(tempNode);
			tempNode.setPrevNode(this.tailNode.getPrevNode());
			this.tailNode.setPrevNode(tempNode);
			tempNode.setNextNode(this.tailNode);
		}
		this.length++;
	}
	
	public void delete(String _name){
		Node tempNode = new Node();
		tempNode = this.headNode;
		for(int i = 0; i < length; i++){
			tempNode = tempNode.getNextNode();
			if(tempNode.getName().equals(_name)){
				tempNode.getPrevNode().setNextNode(tempNode.getNextNode());
				tempNode.getNextNode().setPrevNode(tempNode.getPrevNode());
				tempNode = null;
				return;
			}
		}
		this.length--;
		return;
	}
	
	public void printAll(){
		Node tempNode = new Node();
		tempNode = this.headNode;
		
		for(int i = 0; i < length; i++){
			tempNode = tempNode.getNextNode();
			System.out.print(tempNode.getName() + " ");
		}
		
		System.out.println("");
	}
	
	public String getNodeName(int _index){
		Node tempNode = new Node();
		tempNode = this.headNode.getNextNode();
		String result = "";
		for(int i = 0; i < this.length; i++){
			if(i == _index){
				result = tempNode.getName();
				return result;
			}
			tempNode = tempNode.getNextNode();
		}
		return result;
	}
	
	public Node getNode(String _name){
		Node tempNode = new Node();
		tempNode = this.headNode.getNextNode();
		for(int i = 0; i < this.length; i++){
			if(_name.equals(tempNode.getName())){
				return tempNode;
			}
			tempNode = tempNode.getNextNode();
		}
		
		/**
		 * Error. Not found.
		 */
		return tempNode;
	}
	
	public int getLength(){
		return this.length;
	}
}
