package file;

import java.io.File;

public class FileMain {

	public static void main(String[] args) throws Exception {
		System.out.println("escape charater는 \\ 이다 --> \\축 \"결혼\"");
		System.out.println();
		/*
		 현재파일경로[기준경로]
		 	- eclise --> C:\2023-05-JAVA-DEVELOPER\workspaceSE\20.입출력[IO] (현재이클립스 기준으로 작성)
		 
		 - 상대경로 (relative path) 
		 		현재 경로를 기준점으로 경로를 기술하는 방법
		 		sample\a.txt
		 		.\sample\a.txt (현재경로 . 을 기준으로파일이 존재한다.)
		 		
		 - 절대경로 (absolute path)
		 		C: , D: 드라이브를 기준으로 경로를 기술하는 방법
		 		ex>  C:\2023-05-JAVA-DEVELOPER\workspaceSE\20.입출력[IO]\src\file\FileMain.java
		 				\ : 윈도우 파일 구분자. / : 리눅스,맥 파일 구분자
		 				자바에서는 / 를 사용할수 없음
		 */
		
		File file1 = new File("C:\\2023-05-JAVA-DEVELOPER\\workspaceSE\\20.입출력[IO]\\데미안.txt");
		File file2 = new File("죄와벌.txt");
		File file3 = new File("sample/car1.jpg");
		File file4 = new File("sample/subSample1/01.ArithmaticOperator.txt");
		File file5 = new File("sample/subSample2/11.OOP.txt");
		
		
		System.out.println("------1. file path[relative]------");
		System.out.println(file1.getPath());
		System.out.println(file2.getPath());
		System.out.println(file3.getPath());
		System.out.println(file4.getPath());
		System.out.println(file5.getPath());
		System.out.println();
		
		
		System.out.println("------2. file path[absolute]------");
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file4.getAbsolutePath());
		System.out.println(file5.getAbsolutePath());
		System.out.println();
		
		
		System.out.println("------3. file name------");
		System.out.println(file1.getName());
		System.out.println(file2.getName());
		System.out.println(file3.getName());
		System.out.println(file4.getName());
		System.out.println(file5.getName());
		System.out.println();
		
		
		File dir0 = new File("C:\\2023-05-JAVA-DEVELOPER\\workspaceSE\\20.입출력[IO]");
		File dir1 = new File("sample");
		File dir2 = new File("sample/subSample1");
		File dir3 = new File("sample/subSample2");
		System.out.println("------ isDirectory, isFile------");
		System.out.println(dir0.isDirectory());
		System.out.println(dir1.isDirectory());
		System.out.println();
		
		System.out.println(dir0.isFile());
		System.out.println(dir1.isFile());
		System.out.println();
		
		System.out.println(file1.isDirectory());
		System.out.println(file2.isDirectory());
		
		
		System.out.println();
		System.out.println("------ 디렉토리안에 파일(디렉토리) 목록(String[]) ------");
		
		String[] fileNameList = dir1.list(); // 파일 이름 반환
		for (String fileName : fileNameList) {
			System.out.println("\t" + fileName);
		}
		
		

		System.out.println("------ 디렉토리안에 파일(디렉토리) 목록(File[]) ------");
		
		File[] fileList = dir1.listFiles();
		for (File file : fileList) {
			if(file.isDirectory()) {
				System.out.println("D : " + file.getName());
				// Directory
				File[] subFileList = file.listFiles();
				for (File subFile : subFileList) {
					System.out.println("\t" + subFile.getName());
				}
			}else {
				System.out.println("F : " + file.getName());
				// File
			}
		}
		
		System.out.println("------ 디렉토리(폴더)생성 ------");
		File newDir1 = new File("newDir1");
		File newDir2 = new File("newDir2");
		File newDir3 = new File("sample" , "subSample3");
		File newDir4 = new File("sample/subSample4");
		
		System.out.println(">> newDir1 디렉토리 생성여부 : " + newDir1.mkdir()); 
		// 디렉토리가 없으면 생성해야 하므로 true반환, 있으면 또 만들필요 없으므로 false반환
		System.out.println(">> newDir2 디렉토리 생성여부 : " + newDir2.mkdir()); 
		System.out.println(">> newDir3 디렉토리 생성여부 : " + newDir3.mkdir()); 
		System.out.println(">> newDir4 디렉토리 생성여부 : " + newDir4.mkdir()); 
		
		
		System.out.println();
		System.out.println("------ 디렉토리(폴더)이름 변경 ------");
		newDir2.renameTo(new File("renameDir2"));
		
		
		System.out.println();
		System.out.println("------ 디렉토리(폴더)삭제 ------");
		newDir3.deleteOnExit(); // 있으면 삭제 없으면 말아라.
		
		
		System.out.println();
		System.out.println("------ 파일생성, 삭제, 이름변경 ------");
		
		File newFile1 = new File("newDir1" , "newFile1.txt");
		File newFile2 = new File("newDir1/newFile2.txt");
		File newFile3 = new File("newDir1/newFile3.txt");
		File newFile4 = new File("C:\\2023-05-JAVA-DEVELOPER\\workspaceSE\\20.입출력[IO]\\sample\\subSample4/newFile4.txt");
		
		
		System.out.println("newFile1.txt 생성여부 : " + newFile1.createNewFile());
		System.out.println("newFile2.txt 생성여부 : " + newFile2.createNewFile());
		System.out.println("newFile3.txt 생성여부 : " + newFile3.createNewFile());
		System.out.println("newFile4.txt 생성여부 : " + newFile4.createNewFile());
		
		System.out.println("newFile1.txt 이름변경여부 : " + newFile1.renameTo(new File("newDir1","renameNewFile1.txt")));
		// 파일이 존재하면 삭제하지 않음. 다시하고 싶으면 delete하고 다시 실행해야함
		
		System.out.println("newFile2.txt 삭제여부 : " + newFile2.delete());
		/*
		 에러문장 : System.out.println("newFile2.txt 삭제여부 : " + newFile2.deleteOnExit());
		 The operator + is undefined for the argument type(s) String, void
		 연산자 +는 인수 유형 문자열에 대해 정의되지 않았습니다.
		 이부분을 헷갈려할수 있으므로 주의하기
		 
		 */
		
		
		
		
		
	}

}
