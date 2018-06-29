class MillionGazillion(object):

    def __init__(self,):
        self.letter = {}

    def inpWord(self, word):
        letter = self.letter
        for d in word:
            if letter.has_key(d):
                letter = letter[d]
            else:
                letter[d] = {}
                letter = letter[d]
        
        if letter.has_key('*'):
            return False
        letter['*'] = {}
        return True

# Tests

mg = MillionGazillion()

actual = mg.inpWord('catch')
expected = True
print(expected == actual)

actual = mg.inpWord('cakes')
expected = True
print(expected == actual)

actual = mg.inpWord('cake')
expected = True
print(expected == actual)

actual = mg.inpWord('cake')
expected = False
print(expected == actual)

actual = mg.inpWord('caked')
expected = True
print(expected == actual)

actual = mg.inpWord('catch')
expected = False
print(expected == actual)

