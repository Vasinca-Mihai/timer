this app is meant to help you train by listing a timer and exercise name.
it is also able to read exercises from files
un the folder UserData you can place your custom exercise set
format
is_in_time:ex_time_reps:rest_time_before_ex:ex_name:ex_desc
the items must be separated by a ":" (colon)
is_in_time - boolean (true/false)
ex_time_reps - number of seconds to exercise or number of reps you want to do (depending on is_in_time),
               has to be an integer (whole number)
rest_time_before_ex - number of seconds to rest before the exercise, has to be an integer
ex_name - the name of the exercise you want to set
ex_desc - the description of said exercise, if you want it to not show up just put a " " (space) in its place

in the first menu the file name is to be specified without the extension (no .txt)

additional exercise name pronunciation may be added to the app by placing an audio file in Resources/Sounds,
for the audio file to be linked to the exercise the filename without extension (no .wav) must be the same with ex_name
the audio file must be in the wav format and if it's too long it may overlap with the next sound.