/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.exception;

/**
 *
 * @author yaoshiyun97
 */
public class InvalidLoginException extends Exception
{
    public InvalidLoginException()
    {
    }
    
    public InvalidLoginException(String msg)
    {
        super(msg);
    }
}
