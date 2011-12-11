/*
 * Copyright (C) 2011 Moko365 Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mokoid.media;

import android.content.Context;
import android.os.RemoteException;

import com.mokoid.media.IPlayerControl.Stub;

public class PlayerControl extends IPlayerControl.Stub {

	private static PlayerService mPlayerService;
	
	public PlayerControl(Context context) {
		super();
		// TODO Auto-generated constructor stub
		mPlayerService = (PlayerService)context;
	}

	@Override
	public void Start() throws RemoteException {
		// TODO Auto-generated method stub
		mPlayerService.Start(); // callback
	}

	@Override
	public void Stop() throws RemoteException {
		// TODO Auto-generated method stub
		mPlayerService.Stop();
	}

}
