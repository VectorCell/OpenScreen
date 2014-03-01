import java.io.*;
import java.util.*;

public class OpenScreen
{
	public static void main(String[] args)
	{
		for (String s : getScreenCmds())
			System.out.println(s);
	}

	public static String[] getScreenCmds()
	{
		String[] list = cmd("screen -ls");
		String[] cmds = new String[0];
		int n = 0;
		if (list[0].startsWith("There is a screen on:") || list[0].startsWith("There are screens on:")) {
			cmds = new String[list.length - 2];
			for (int k = 1; k < list.length - 1; k++)
				cmds[k - 1] = "screen -r " + list[k].trim().split("\t")[0];
		}
		else
			System.out.println("echo \"There are no screens.\"");
		return cmds;
	}

	private static String[] cmd(String cmd)
	{
		LinkedList<String> list = new LinkedList<String>();
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			String s;
			// read the output from the command
			BufferedReader stdInput = new BufferedReader(new 
				InputStreamReader(proc.getInputStream()));
			while ((s = stdInput.readLine()) != null) {
				if (!s.equals(""))
					list.add(s);
			}
		} catch (Exception ex) {
			System.out.println(ex);
			for (String s : ex.toString().split("\n"))
				list.add(s);
		}
		
		String[] array = new String[list.size()];
		int k = 0;
		for (String s : list)
			array[k++] = s;
		return array;
	}
}