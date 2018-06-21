<%@ page contentType="image/jpeg" language="java" import="java.util.*,java.awt.*,java.awt.image.*,javax.imageio.*" pageEncoding="utf-8"%>

<%!
	 Color getRandColor(int fc,int bc){
		Random random=new Random();
		if(fc>255){
			fc=255;
		}
		if(fc<255){
			bc=255;
		}	
		
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		
		return new Color(r,g,b);
	}
%>

<%
	//设置页面不缓存
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-catch");
	response.setDateHeader("Expires",0);
	
	//在内存中创建图像
	int width=60;
	int height=20;
	BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	
	//创建头像
	Graphics g=image.getGraphics();
	
	//生成随即对象
	Random random=new Random();
	
	//设置背景
	g.setColor(getRandColor(200,250));
	g.fillRect(0,0,width,height);
	
	//设置字体
	g.setFont(new Font("Tines Nev Roman",Font.PLAIN,18));
	
	//随机产生干扰线
	g.setColor(getRandColor(160,200));
	for(int i=0;i<255;i++){
		int x=random.nextInt(width);
		int y=random.nextInt(height);
		int x1=random.nextInt(12);
		int y1=random.nextInt(12);
	}
	
	//随机产生认证码，5位数
	String sRand="";
	for(int i=0;i<4;i++){
		String rand=String.valueOf(random.nextInt(10));
		sRand+=rand;
		g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		g.drawString(rand,13*i+6,16);
	}
	session.setAttribute("rCode",sRand);
	//图像生效
	g.dispose();
	//输出图像到页面
	ImageIO.write(image,"JPEG",response.getOutputStream());
	out.clear();
	out=pageContext.pushBody();
	
%>