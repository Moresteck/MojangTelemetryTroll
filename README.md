# What is this?
This is le epic software made to troll Mojang telemetry. You can send custom telemetry data, that means you can set the following properties to whatever you like:
- client version
- java version
- operating system (and its version)
- gamemode
- modded status
- "server type"

**xuid** and **clientid** arguments are nullable, you only have to pass your **accesstoken**

**This software is dedicated for professional users. Please be professional while using it.**
Support won't be provided for non-professional users.

### Expected behavior

Command `send` should return the following lines:
```
{
	"status": "OK"
}
```
If not, well, something's not right then.

## Dependency: gson

This project came to be because Mojang recently decided to force telemetry on players in the newest 1.18 versions.
So, to express my disgust and opposition, I decided to make this simple piece of software. Hope it helps you!
