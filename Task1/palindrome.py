def palindrome(s):
    #first we removed the punctuation
    s=s.replace(',','')
    s=s.replace(' ','')
    s=s.replace('-','')
    s=s.replace('!','')
    s=s.replace('?','')
    s=s.replace(';','')
    s=s.replace("'",'')
    s=s.lower()
    l=len(s)
    t=True
     
    #then we checked if the string is palindrome or not
   
        #the moment we know it's impossible we break and return false
    if(s[i]==s[::-1]):
        return True
    #else we return true
    else :
        return False

print(palindrome("Madam, in Eden, I'm Adam"))
print(palindrome("Complete the project report"))
