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
    for i in range(0,l%2-1):
        print(s[i])
        print(s[l-i])
        #the moment we know it's impossible we break and return false
        if(s[i]!=s[l-i]):
            t=False
            break
    #else we return true
    return t

print(palindrome("Madam, in Eden, I'm Adam"))
print(palindrome("Complete the project report"))
