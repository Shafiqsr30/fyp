

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Gesture.State;

class LeapListener extends Listener {
public void onInit(Controller controller){
System.out.println("initialize");
}

public void onConnect(Controller controller){
	System.out.println("Connected to motion sensor");
	controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}

public void onDisconnect(Controller controller){
	System.out.println("Motion sensor disconnected");
}

public void onExit(Controller controller){
	System.out.println("Exit");
}

public boolean isStreched(Frame frame, String fingerthumb){
	boolean result = false;
for (Finger finger : frame.fingers()){
	
	Type fingerType = finger.type();
	String fingerStr = fingerType.toString();
	if(fingerStr == fingerthumb ){
		float xProxPrev = 0;
		float xDisEnd = 0; //TYPE_PROXIMAL
		
		for (Bone.Type boneType : Bone.Type.values()){
			Bone bone = finger.bone(boneType);
			Vector valInit = bone.prevJoint();
			Vector valEnd = bone.nextJoint();
			
			String boneName = boneType.toString();
			//System.out.println(boneName);
			
			
			if(boneName == "TYPE_PROXIMAL"){
				xProxPrev = valInit.getX();
				float zProxPrev = valInit.getZ();
				
				//System.out.println("dist is " + zProxPrev);
				//System.out.println(valInit);
				
			}
			if(boneName == "TYPE_DISTAL"){
				xDisEnd = valEnd.getX();
				//System.out.println(xDisEnd);
				
			}
		} 
		float dist = xProxPrev - xDisEnd;
		if (dist > 40) {
			result = false;
			//System.out.println("my hand is streteched");
		} else {
			result = true;
			//System.out.println("my hand is bended");
		}
		
		try {
			TimeUnit.SECONDS.sleep((long) 0.5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 

return result;
}
	
public boolean isBent(Frame frame, String fingerName) {
	boolean result = false;
for (Finger finger : frame.fingers()){
		
		Type fingerType = finger.type();
		String fingerStr = fingerType.toString();
		if(fingerStr == fingerName ){
			float zMetaPrev = 0;
			float zDisEnd = 0; //TYPE_PROXIMAL
			
			for (Bone.Type boneType : Bone.Type.values()){
				Bone bone = finger.bone(boneType);
				Vector valInit = bone.prevJoint();
				Vector valEnd = bone.nextJoint();
				
				String boneName = boneType.toString();
				//System.out.println(boneName);
				
				
				if(boneName == "TYPE_METACARPAL"){
					zMetaPrev = valInit.getZ();
					float xMetaPrev = valInit.getX();
					
					//System.out.println("dist is " + dist);
					//System.out.println(valInit);
					
				}
				if(boneName == "TYPE_DISTAL"){
					zDisEnd = valEnd.getZ();
					//System.out.println(zDisEnd);
					
				}
			} 
			float dist = zMetaPrev - zDisEnd;
			if (dist > 100) {
				result = false;
				//System.out.println("my hand is streteched");
			} else {
				result = true;
				//System.out.println("my hand is bended");
			}
			
			try {
				TimeUnit.SECONDS.sleep((long) 0.5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	} 

return result;
}

public boolean isSpecial(Frame frame, String fingerName) {
	boolean result = false;
for (Finger finger : frame.fingers()){
		
		Type fingerType = finger.type();
		String fingerStr = fingerType.toString();
		if(fingerStr == fingerName ){
			
			float xDisEnd = 0; //TYPE_PROXIMAL
			float xMetaPrev = 0;
			
			for (Bone.Type boneType : Bone.Type.values()){
				Bone bone = finger.bone(boneType);
				Vector valInit = bone.prevJoint();
				Vector valEnd = bone.nextJoint();
				
				String boneName = boneType.toString();
				//System.out.println(boneName);
				
				
				if(boneName == "TYPE_METACARPAL"){
					xMetaPrev = valInit.getX();
					
					
					//System.out.println( "xmetaprev is " + xMetaPrev);
					//System.out.println(valInit);
					
				}
				if(boneName == "TYPE_DISTAL"){
					xDisEnd = valEnd.getX();
					//System.out.println( "xDisEnd is " + xDisEnd);
					
				}
			} 
			float dist = xMetaPrev - xDisEnd;
			if (dist > 40) {
				result = false;
				//System.out.println("my hand is streteched");
			} else {
				result = true;
				//System.out.println("my hand is bended");
			}
			
			try {
				TimeUnit.SECONDS.sleep((long) 0.5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	} 

return result;
}

public boolean isUnique(Frame frame, String fingerName) {
	boolean result = false;
for (Finger finger : frame.fingers()){
		
		Type fingerType = finger.type();
		String fingerStr = fingerType.toString();
		if(fingerStr == fingerName ){
			float zMetaPrev = 0;
			float zDisEnd = 0; //TYPE_PROXIMAL
			
			for (Bone.Type boneType : Bone.Type.values()){
				Bone bone = finger.bone(boneType);
				Vector valInit = bone.prevJoint();
				Vector valEnd = bone.nextJoint();
				
				String boneName = boneType.toString();
				//System.out.println(boneName);
				
				
				if(boneName == "TYPE_METACARPAL"){
					zMetaPrev = valInit.getZ();
					float xMetaPrev = valInit.getX();
					
					//System.out.println("dist is " + zMetaPrev );
					//System.out.println(valInit);
					
				}
				if(boneName == "TYPE_DISTAL"){
					zDisEnd = valEnd.getZ();
					//System.out.println(zDisEnd);
					
				}
			} 
			float dist = zMetaPrev - zDisEnd;
			if (dist > 90) {
				result = false;
				//System.out.println("my hand is streteched");
			} else {
				result = true;
				//System.out.println("my hand is bended");
			}
			
			try {
				TimeUnit.SECONDS.sleep((long) 0.5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	} 

return result;
}

public void onFrame(Controller controller){
	Frame frame = controller.frame();
//		 System.out.println("Frame id: " + frame.id()
//			           + ", Timestamp: " + frame.timestamp()
//			           + ", Hands: " + frame.hands().count()
//			           + ", Fingers: " + frame.fingers().count()  
//			           + ", Tools: " + frame.tools().count()
//			           + ", Gestures: " + frame.gestures().count()); 
	
	
	
//	 for (Hand hand: frame.hands()){
//		String handType = hand.isLeft() ? "Left Hand" : "Right Hand";
//		System.out.println(handType);
////		System.out.println(handType + "" + ", id: " + hand.id()
////		           + ", Palm Position" + hand.palmPosition());
//		
////		Vector normal = hand.palmNormal();
////		Vector direction = hand.direction();
////		
////		System.out.println("Pitch: " + Math.toDegrees(direction.pitch())
////							+ " Roll: " + Math.toDegrees(normal.roll())
////							+ " Yaw: " + Math.toDegrees(direction.yaw()));
//	} 
	
	if(isBent(frame, "TYPE_MIDDLE") && isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && isBent(frame, "TYPE_PINKY") && !isStreched(frame, "TYPE_THUMB")) 
		{
		System.out.println("A");
		}
	
	else if(isBent(frame, "TYPE_MIDDLE") && isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && isBent(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB")) 
		{
		System.out.println("S");
		}
	
	else if(!isBent(frame, "TYPE_MIDDLE") && !isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && isBent(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB")) 
		{	
		System.out.println("U");
		}
	
	else if(isBent(frame, "TYPE_MIDDLE") && !isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && isBent(frame, "TYPE_PINKY") && !isStreched(frame, "TYPE_THUMB"))
		{
		System.out.println("L");
		}
	
	else if(isBent(frame, "TYPE_MIDDLE") && isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && !isBent(frame, "TYPE_PINKY") && !isStreched(frame, "TYPE_THUMB"))
		{
		System.out.println("Y");
		}
	
	else if(!isBent(frame, "TYPE_MIDDLE") && !isBent(frame, "TYPE_INDEX") && !isBent(frame, "TYPE_RING") && !isBent(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB"))
		{
		System.out.println("B");
		}
	
	else if(isBent(frame, "TYPE_MIDDLE") && !isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && isBent(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB"))
		{
		System.out.println("D");
		}
	
	else if(!isBent(frame, "TYPE_MIDDLE") && !isBent(frame, "TYPE_INDEX") && !isBent(frame, "TYPE_RING") && isBent(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB"))
		{
		System.out.println("W");
		}
	
	else if(isBent(frame, "TYPE_MIDDLE") && isBent(frame, "TYPE_INDEX") && isBent(frame, "TYPE_RING") && !isBent(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB"))
		{
		System.out.println("I");
		}
	
	else if(isSpecial(frame, "TYPE_MIDDLE") && !isSpecial(frame, "TYPE_INDEX") && isSpecial(frame, "TYPE_RING") && isSpecial(frame, "TYPE_PINKY") && !isStreched(frame, "TYPE_THUMB")) 
		{
			System.out.println("G");
		} 
	
	else if(!isSpecial(frame, "TYPE_MIDDLE") && !isSpecial(frame, "TYPE_INDEX") && isSpecial(frame, "TYPE_RING") && isSpecial(frame, "TYPE_PINKY") && !isStreched(frame, "TYPE_THUMB")) 
		{
			System.out.println("H");
		} 
	
	else if(isUnique(frame, "TYPE_MIDDLE") && isUnique(frame, "TYPE_INDEX") && isUnique(frame, "TYPE_RING") && isUnique(frame, "TYPE_PINKY") && isStreched(frame, "TYPE_THUMB")) 
	{
		System.out.println("C");
	} 

	else 
		{
		System.out.println("NOT HAND DETECTED");
		}
	
		isBent(frame, "TYPE_INDEX");
		isStreched(frame, "TYPE_THUMB");
		isSpecial(frame, "TYPE_INDEX");
		isUnique(frame, "TYPE_INDEX");
	
	/*
	for (Tool tool : frame.tools()){
		System.out.println("Tool ID: " + tool.id()
				+ " Tip Position: " + tool.tipPosition()
				+ " Direction: " + tool.direction()
				+ " Width: " + tool.width()
				+ " Touch Distance(mm): " + tool.touchDistance());
	} 
	*/
	
//	 GestureList gestures = frame.gestures();
//	for (int i = 0; i < gestures.count(); i++) {
//		Gesture gesture = gestures.get(i);
//		
//		switch (gesture.type()){
//		case TYPE_CIRCLE:
//			CircleGesture circle = new CircleGesture(gesture);
//			
//			String clockwiseness;
//			if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/4){
//				clockwiseness = "clockwise";
//				}else {
//					clockwiseness = "counter-clockwise";
//				}
//			
//			double sweptAngle = 0;
//			if (circle.state()!= State.STATE_START){
//				CircleGesture previous = new CircleGesture(controller.frame(1).gesture(circle.id()));
//				sweptAngle = (circle.progress()-previous.progress()) * 2 * Math.PI; 
//			}
//			
//			System.out.println("Circle ID: " + circle.id()
//								+ " State: " + circle.state()
//								+ " Progress: " + circle.progress()
//								+ " Radius: " + circle.radius()
//								+ " Angle: " + Math.toDegrees(sweptAngle)
//								+ " " + clockwiseness );
//			break;
//		case TYPE_SWIPE:
//			SwipeGesture swipe = new SwipeGesture(gesture);
//			System.out.println("Swipe ID: " + swipe.id()
//					+ "state: " + swipe.state()
//					+ "Swipe Position: " + swipe.position()
//					+ "Direction " + swipe.direction()
//					+ "speed " + swipe.speed());
//			
//			
//					
//			try {
//				TimeUnit.SECONDS.sleep((long) 0.5);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//					
//		}
//		
//	}	
}

}

public class LeapController {

	public static void main(String[] args) {
		LeapListener listener = new LeapListener();
		Controller controller = new Controller();
		
		controller.addListener(listener);
		
		System.out.println("Press Enter To Quit");
		
		try{
			System.in.read();
		} catch (IOException e){
			e.printStackTrace();
		}
		controller.removeListener(listener);
	}

}
