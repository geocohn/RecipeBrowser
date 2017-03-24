# Recipe Browser
### Week 4

This project is a demo to illustrate the use of Fragments and ViewPagers.

The app presents a list of recipes from a JSON stream stored as an ``assets`` resource.
When the user clicks on a recipe, the app uses a switch in the AppBar to choose a Detail Activity.

There are two detail activities:
1. ``RecipeDetailActivityLinear`` uses a Fragment View in the XML layout to display a single fragment
2. ``RecipeDetailActivityResponsive`` uses a ViewPager to display 3 fragments when the device is oriented vertically, and displays the same 3 fragments side by side when the device is rotated horizontally.

## Authors

* **George Cohn** - *Initial work* - https://github.com/GeoCohn

## License

Copyright 2017 George Cohn III

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
