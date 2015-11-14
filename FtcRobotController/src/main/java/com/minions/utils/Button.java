package com.minions.utils;

/**
 * Created by doug on 11/7/2015.
 */
public class Button {
    private  boolean _currentlyPressed;
    private IButtonChanged _onButtonChanged;
    private boolean _asToggle;

    public Button(boolean isToggleButton, IButtonChanged onButtonChanged){
        _asToggle = isToggleButton;
        _onButtonChanged = onButtonChanged;
    }

    public void handleButton(boolean buttonPressed) {
        if(_asToggle){
            checkState(buttonPressed);
        } else {
            if(buttonPressed) {
                _onButtonChanged.buttonPressed();
            } else {
                _onButtonChanged.buttonReleased();
            }

            //_onButtonChanged.buttonState(buttonPressed);
        }
    }

    private void checkState(boolean buttonPressed) {

        if(buttonPressed) {
            if(!_currentlyPressed) {
                if(_onButtonChanged != null) {
                    _onButtonChanged.buttonPressed();
                    //_onButtonChanged.buttonState(buttonPressed);
                }
                _currentlyPressed = true;
            }
        } else {
            if(_currentlyPressed) {
                if(_onButtonChanged != null) {
                    //_onButtonChanged.buttonState(buttonPressed);
                    _onButtonChanged.buttonReleased();
                }
                _currentlyPressed = false;
            }


        }

    }

}

public interface IButtonChanged {
    //void buttonState(boolean buttonPressed);
    void buttonPressed();
    void buttonReleased();
}