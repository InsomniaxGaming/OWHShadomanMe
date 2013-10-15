package info.insomniax.bukkit.owhshadomanme.command;

import info.insomniax.bukkit.owhshadomanme.OWHShadomanMe;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MyHandler implements CommandExecutor {
	private OWHShadomanMe myPlugin = null;
	
	public MyHandler(OWHShadomanMe instance)
	{
		this.setMyPlugin(instance);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// First figure out which command we are processing
		// myall
		if(cmd.toString().equalsIgnoreCase("myall"))
		{
			// If player, check for nodes.
			if(sender instanceof Player)
			{
				if(this.myPlugin.playerHasNode(sender.getName(), this.myPlugin.myMyAllNode.getMyNode()))
				{
					// Permed
					// Assemble the emote for EVERY player on the server. And send it globally.
					myAll(args);
					return true;
					
				} else {
					// Not Permed.
					sender.sendMessage(this.myPlugin.myErrorMSG);
					return true;
				}
			} else {
				// Console, do eet.
				myAll(args);
				return true;
			}
		}
		
		// my
		if(cmd.toString().equalsIgnoreCase("my"))
		{
			// Tell the Console to get lost. Consoles cant emote.
			if(sender instanceof ConsoleCommandSender) {
				sender.sendMessage("Consoles cant emote. End of Line.");
				return true;
			}
			
			// Check Perms
			if(this.myPlugin.playerHasNode(sender.getName(), this.myPlugin.myMyNode.getMyNode()))
			{
				// Permed.
				my(sender.getName(), args);
				return true;
			} else {
				// Not Permed.
				sender.sendMessage(this.myPlugin.myErrorMSG);
				return true;
				
			}
		}
		
		return false;
	}
	
	private void myAll(String[] args)
	{
		// Assemble strings for every player online, and send them to everyone.
		for(Player p:this.myPlugin.getServer().getOnlinePlayers())
		{
			this.myPlugin.sendToAll(p.getName() + "'s " + StringUtils.join(args," "));
		}
	}
	
	private void my(String name, String[] args)
	{
		// Determine if we are emoting Globally or not.
		if(this.myPlugin.playerHasNode(name, this.myPlugin.myMyGlobalNode.getMyNode()))
		{
			// Emotes Globally!
			// Assemble the string for the name, and send it to ... Everyone.
			this.myPlugin.sendToAll(name + "'s " + StringUtils.join(args, " "));
		} else {
			// Emotes Locally!
			// 	Assemble the string for the name, and send it to players in the world with the player the name belongs to.
			for(Player p:this.myPlugin.getServer().getPlayerExact(name).getWorld().getPlayers())
			{
				//	For each player in the world with the player;
				this.myPlugin.sendToPlayer(p.getName(), name + "'s " + StringUtils.join(args," "));
			}
		}
		
	}
	
	/**
	 * @return the myPlugin
	 */
	public OWHShadomanMe getMyPlugin() {
		return myPlugin;
	}

	/**
	 * @param myPlugin the myPlugin to set
	 */
	public void setMyPlugin(OWHShadomanMe myPlugin) {
		this.myPlugin = myPlugin;
	}

}