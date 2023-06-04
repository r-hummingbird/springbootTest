package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {
	public static void run_cmd(String strcmd) {
//
		Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
		Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
		try {
			ps = rt.exec(strcmd);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
			ps.waitFor();  //等待子进程完成再往下执行。
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ps.destroy();  //销毁子进程
		ps = null;
		System.out.println("done");
	}
	@GetMapping("/")
	public String index() {
		String strcmd = "cmd /c start  test.bat";  //调用我们在项目目录下准备好的bat文件，如果不是在项目目录下，则把“你的文件名.bat”改成文件所在路径。
		run_cmd(strcmd);  //调用上面的run_cmd方法执行操作
		return "OSGB模型转化";
	}

}
