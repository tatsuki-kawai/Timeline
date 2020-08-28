package model;

import java.util.List;

public class PostAction {
	public void execute(List<Action> actions, Action action){
		String[] actionWords = action.getWhen().split(":");
		int actionTime = Integer.parseInt(actionWords[0] + actionWords[1]);

		for(Action a: actions) {
			String[] aWords = a.getWhen().split(":");
			int aTime = Integer.parseInt(aWords[0] + aWords[1]);

			if(actionTime < aTime) {
				int index = actions.indexOf(a);
				actions.add(index,action);
				return;
			}
		}
		actions.add(action);
	}

}
