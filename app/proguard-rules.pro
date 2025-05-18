# Here is the content for the file: /app/proguard-rules.pro

# ProGuard rules for the Labmaj application
# Keep the main activity and other activities
-keep public class com.example.labmaj.MainActivity {
    public <init>(...);
}
-keep public class com.example.labmaj.SettingsActivity {
    public <init>(...);
}
-keep public class com.example.labmaj.AboutActivity {
    public <init>(...);
}
-keep public class com.example.labmaj.PhysicsView {
    public <init>(...);
}
-keep public class com.example.labmaj.SoundManager {
    public <init>(...);
}

# Keep all public methods and fields in the SoundManager class
-keepclassmembers class com.example.labmaj.SoundManager {
    public *;
}

# Keep all public methods and fields in the PhysicsView class
-keepclassmembers class com.example.labmaj.PhysicsView {
    public *;
}

# Keep all public methods and fields in the SettingsActivity class
-keepclassmembers class com.example.labmaj.SettingsActivity {
    public *;
}

# Keep all public methods and fields in the AboutActivity class
-keepclassmembers class com.example.labmaj.AboutActivity {
    public *;
}