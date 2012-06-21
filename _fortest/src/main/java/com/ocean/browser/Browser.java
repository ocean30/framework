/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 *
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
package com.ocean.browser;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserCommandEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserListener;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowOpeningEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowWillOpenEvent;

/**
 * @author Christopher Deckers
 */
public class Browser {

  public JComponent createContent(final String accountNo,String URL) {
    JPanel contentPane = new JPanel(new BorderLayout());
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
    webBrowserPanel.setBorder(BorderFactory.createTitledBorder("Mwt browser"));
    JWebBrowser.clearSessionCookies();
    final JWebBrowser webBrowser = new JWebBrowser();
    webBrowser.navigate(URL);
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    contentPane.add(webBrowserPanel, BorderLayout.CENTER);
    // Create an additional bar allowing to show/hide the menu bar of the web browser.
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
    JCheckBox menuBarCheckBox = new JCheckBox("Menu Bar", webBrowser.isMenuBarVisible());
    menuBarCheckBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        webBrowser.setMenuBarVisible(e.getStateChange() == ItemEvent.SELECTED);
      }
    });
    webBrowser.addWebBrowserListener(new WebBrowserListener() {
		private boolean firstLoad=true;

		public void windowWillOpen(WebBrowserWindowWillOpenEvent e) {
		}
		public void windowOpening(WebBrowserWindowOpeningEvent e) {
		}
		public void windowClosing(WebBrowserEvent e) {
		}
		public void titleChanged(WebBrowserEvent e) {
		}
		public void statusChanged(WebBrowserEvent e) {
		}
		public void locationChanging(WebBrowserNavigationEvent e) {
		}
		public void locationChanged(WebBrowserNavigationEvent e) {
		}
		public void locationChangeCanceled(WebBrowserNavigationEvent e) {
		}
		public void loadingProgressChanged(WebBrowserEvent e) {
			if(webBrowser.getLoadingProgress()==100 && firstLoad){
				System.out.println("accountNo: " + accountNo);
				webBrowser.executeJavascript("javascript:document.getElementById('realUserName').value='"+ accountNo +"';realAccountLogon();");
				firstLoad = false ;
			}
		}
		public void commandReceived(WebBrowserCommandEvent e) {
		}
	});
    buttonPanel.add(menuBarCheckBox);
    contentPane.add(buttonPanel, BorderLayout.SOUTH);
//    webBrowser.executeJavascript("javascript:document.getElementById('realUserName').value='0018136';alert(document.getElementById('realUserName').value);realAccountLogon();");
    return contentPane;
  }

  /* Standard main method to try that test as a standalone application. */
  public static void main(String[] args) {
	  String prefix0 = "00" ;
	  int surfix = 18126 ;
	  int windowNum = 2 ;
	  int period = 5000;
	  String URL0 = "http://127.0.0.1:8080/mwt11";
	  if(args.length<5){
		  System.out.println("Usage: MwtLogon 【prefix】surfix  windowNum period URL");
		  System.out.println("【prefix】default is 00\r\nsurfix default is 18126\r\nwindowNum default is 1\r\nperiod default 500 ms\r\nURL default is http://127.0.0.1:8080/mwt11");
	  }else{
		  prefix0 = args[0] ;
		  surfix = Integer.valueOf(args[1]);
		  windowNum = Integer.valueOf(args[2]) ;
		  period =  Integer.valueOf(args[3]);
		  URL0 = args[4];
	  }
	  final String prefix = prefix0 ;
	  final String URL = URL0 ;
    NativeInterface.open();
    UIUtils.setPreferredLookAndFeel();
    for(int i =0; i<windowNum; i++){
    	final int accountNo = surfix + i ;
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        JFrame frame = new JFrame("Mwt User Test");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
			frame.getContentPane().add(new Browser().createContent(prefix + accountNo,URL ), BorderLayout.CENTER);
	        
	        frame.setSize(1024, 600);
	        frame.setLocationByPlatform(true);
	        frame.setVisible(true);
	      }
	    });
	    try {
			Thread.sleep(period);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    NativeInterface.runEventPump();
  }

}