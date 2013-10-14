package info.insomniax.bukkit.owhshadomanme;

import info.insomniax.bukkit.core.PermissionNode;
import info.insomniax.bukkit.owhshadomanme.command.MeHandler;
import info.insomniax.bukkit.owhshadomanme.command.MyHandler;

public class OWHShadomanMe extends info.insomniax.bukkit.core.BukkitPlugin {
	// Permission Nodes
	public PermissionNode myMeNode = new PermissionNode("insomniax.me"); // local /me
	public PermissionNode myMeAllNode = new PermissionNode("insomniax.me.all"); // global /meall
	public PermissionNode myMeGlobalNode = new PermissionNode("insomniax.me.global"); // global /me
	
	public PermissionNode myMyNode = new PermissionNode("insomniax.my"); // local /my
	public PermissionNode myMyAllNode = new PermissionNode("insomniax.my.all"); // global /myall
	public PermissionNode myMyGlobalNode = new PermissionNode("insomniax.my.global"); // Global /my
	
	// Built in Message
	public String myErrorMSG = "I'm Sorry Dave. I can't let you do that...";
	
	
	// Plugin Loading 
	@Override
	public void onEnable()
	{
		this.consoleInfo("Enabling...");
				
		// Make sure Vault is working...
		if(!(this.setupPermissions())) this.consoleInfo("Failed to setup Vault Permisions...");
		if(!(this.setupEconomy())) this.consoleInfo("Failed to setup Vault Economy...");
		if(!(this.setupChat())) this.consoleInfo("Failed to setup Vault Chat...");
		
		// Keeping references to the command handlers:
		MeHandler meHandler = new MeHandler(this);
		MyHandler myHandler = new MyHandler(this);
		
		// Assign the Command Handlers
		this.getCommand("me").setExecutor(meHandler);
		this.getCommand("meall").setExecutor(meHandler);
		this.getCommand("my").setExecutor(myHandler);
		this.getCommand("myall").setExecutor(myHandler);
		
		this.consoleInfo("Enable completed.");
	}

	// Plugin Unloading
	@Override
	public void onDisable()
	{
			
	}
	
	// Getters/Setters
	/**
	 * @return the myMeNode
	 */
	PermissionNode getMyMeNode() {
		return myMeNode;
	}

	/**
	 * @param myMeNode the myMeNode to set
	 */
	void setMyMeNode(PermissionNode myMeNode) {
		this.myMeNode = myMeNode;
	}

	/**
	 * @return the myMeAllNode
	 */
	PermissionNode getMyMeAllNode() {
		return myMeAllNode;
	}

	/**
	 * @param myMeAllNode the myMeAllNode to set
	 */
	void setMyMeAllNode(PermissionNode myMeAllNode) {
		this.myMeAllNode = myMeAllNode;
	}

	/**
	 * @return the myMeGlobalNode
	 */
	PermissionNode getMyMeGlobalNode() {
		return myMeGlobalNode;
	}

	/**
	 * @param myMeGlobalNode the myMeGlobalNode to set
	 */
	void setMyMeGlobalNode(PermissionNode myMeGlobalNode) {
		this.myMeGlobalNode = myMeGlobalNode;
	}

	/**
	 * @return the myMyNode
	 */
	PermissionNode getMyMyNode() {
		return myMyNode;
	}

	/**
	 * @param myMyNode the myMyNode to set
	 */
	void setMyMyNode(PermissionNode myMyNode) {
		this.myMyNode = myMyNode;
	}

	/**
	 * @return the myMyAllNode
	 */
	PermissionNode getMyMyAllNode() {
		return myMyAllNode;
	}

	/**
	 * @param myMyAllNode the myMyAllNode to set
	 */
	void setMyMyAllNode(PermissionNode myMyAllNode) {
		this.myMyAllNode = myMyAllNode;
	}

	/**
	 * @return the myMyGlobalNode
	 */
	PermissionNode getMeMyGlobalNode() {
		return myMyGlobalNode;
	}

	/**
	 * @param meMyGlobalNode the meMyGlobalNode to set
	 */
	void setMyMyGlobalNode(PermissionNode meMyGlobalNode) {
		this.myMyGlobalNode = meMyGlobalNode;
	}
	
}


