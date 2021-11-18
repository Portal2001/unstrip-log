package vb.$unstriplog;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getDataFolder().mkdir();
		getServer().getPluginManager().registerEvents(this, this);
		try {
			((org.bukkit.command.CommandSender) (Object) org.bukkit.Bukkit.getConsoleSender())
					.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2yo yo "));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		try {
			((org.bukkit.command.CommandSender) (Object) org.bukkit.Bukkit.getConsoleSender())
					.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2yo yo "));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteractEvent1(org.bukkit.event.player.PlayerInteractEvent event) throws Exception {
		if ((((org.bukkit.permissions.Permissible) (Object) event.getPlayer()).hasPermission("unstrip.oak")
				&& PluginMain.checkEquals(event.getAction(), org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
			if (PluginMain.checkEquals(event.getClickedBlock().getType(), org.bukkit.Material.STRIPPED_OAK_LOG)) {
				event.getClickedBlock().setType(org.bukkit.Material.OAK_LOG);
			}
		}
		if ((((org.bukkit.permissions.Permissible) (Object) event.getPlayer()).hasPermission("unstrip.acacia")
				&& PluginMain.checkEquals(event.getAction(), org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
			if (PluginMain.checkEquals(event.getClickedBlock().getType(), org.bukkit.Material.STRIPPED_ACACIA_LOG)) {
				event.getClickedBlock().setType(org.bukkit.Material.ACACIA_LOG);
			}
		}
		if ((((org.bukkit.permissions.Permissible) (Object) event.getPlayer()).hasPermission("unstrip.birch")
				&& PluginMain.checkEquals(event.getAction(), org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
			if (PluginMain.checkEquals(event.getClickedBlock().getType(), org.bukkit.Material.STRIPPED_BIRCH_LOG)) {
				event.getClickedBlock().setType(org.bukkit.Material.BIRCH_LOG);
			}
		}
		if ((((org.bukkit.permissions.Permissible) (Object) event.getPlayer()).hasPermission("unstrip.dark_oak")
				&& PluginMain.checkEquals(event.getAction(), org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
			if (PluginMain.checkEquals(event.getClickedBlock().getType(), org.bukkit.Material.STRIPPED_DARK_OAK_LOG)) {
				event.getClickedBlock().setType(org.bukkit.Material.DARK_OAK_LOG);
			}
		}
		if ((((org.bukkit.permissions.Permissible) (Object) event.getPlayer()).hasPermission("unstrip.spruce")
				&& PluginMain.checkEquals(event.getAction(), org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
			if (PluginMain.checkEquals(event.getClickedBlock().getType(), org.bukkit.Material.STRIPPED_SPRUCE_LOG)) {
				event.getClickedBlock().setType(org.bukkit.Material.SPRUCE_LOG);
			}
		}
		if ((((org.bukkit.permissions.Permissible) (Object) event.getPlayer()).hasPermission("unstrip.jungle")
				&& PluginMain.checkEquals(event.getAction(), org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
			if (PluginMain.checkEquals(event.getClickedBlock().getType(), org.bukkit.Material.STRIPPED_JUNGLE_LOG)) {
				event.getClickedBlock().setType(org.bukkit.Material.JUNGLE_LOG);
			}
		}
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
